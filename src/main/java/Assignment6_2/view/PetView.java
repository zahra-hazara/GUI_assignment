package Assignment6_2.view;

import Assignment6_2.controller.PetController;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class VirtualPetApp{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(VirtualPetApp::run);
    }

    private static void run() {
        JFrame frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pet pet = new Pet(300, 200);
        PetController controller = new PetController(pet, 5);

        try {
            GraphicsDemo demoPanel = new GraphicsDemo(controller, "path/to/cute_pet_image.png") {
                @Override
                public void start(Stage stage) throws Exception {

                }
            };
            frame.add(demoPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (IOException e) {
            System.err.println("Error loading the pet image.");
        }
    }
}