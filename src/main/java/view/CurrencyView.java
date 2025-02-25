package view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Currency;

public class CurrencyView extends Application {
    private CurrencyController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new CurrencyController();

        // Create UI components
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        Label fromLabel = new Label("From Currency:");
        ComboBox<Currency> fromCurrencyBox = new ComboBox<>();
        fromCurrencyBox.getItems().addAll(controller.getCurrencies());
        fromCurrencyBox.setPromptText("Select currency");

        Label toLabel = new Label("To Currency:");
        ComboBox<Currency> toCurrencyBox = new ComboBox<>();
        toCurrencyBox.getItems().addAll(controller.getCurrencies());
        toCurrencyBox.setPromptText("Select currency");

        Label resultLabel = new Label("Converted Amount:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Button convertButton = new Button("Convert");

        // Set up the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(amountLabel, 0, 0);
        gridPane.add(amountField, 1, 0);
        gridPane.add(fromLabel, 0, 1);
        gridPane.add(fromCurrencyBox, 1, 1);
        gridPane.add(toLabel, 0, 2);
        gridPane.add(toCurrencyBox, 1, 2);
        gridPane.add(resultLabel, 0, 3);
        gridPane.add(resultField, 1, 3);
        gridPane.add(convertButton, 1, 4);

        // Set up the event handler for the convert button
        convertButton.setOnAction(event -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency fromCurrency = fromCurrencyBox.getValue();
                Currency toCurrency = toCurrencyBox.getValue();

                if (fromCurrency == null || toCurrency == null) {
                    resultField.setText("Please select both currencies.");
                } else {
                    double convertedAmount = controller.convert(amount, fromCurrency, toCurrency);
                    resultField.setText(String.format("%.2f", convertedAmount));
                }
            } catch (NumberFormatException e) {
                resultField.setText("Invalid amount. Please enter a number.");
            }
        });

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 400, 250);

        // Load the CSS file from the resources folder with null check
        String cssPath = getClass().getResource("/resources/styles.css").toExternalForm();
        if (cssPath != null) {
            scene.getStylesheets().add(cssPath);
        } else {
            System.err.println("CSS file not found! Ensure the file is in the resources folder.");
        }

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}