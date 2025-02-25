package controller;

import model.Currency;
import java.util.ArrayList;
import java.util.List;

public class CurrencyController {
    private List<Currency> currencies;

    public CurrencyController() {
        currencies = new ArrayList<>();
        // Hardcode some currencies for initial development
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.94));
        currencies.add(new Currency("GBP", "British Pound", 0.82));
        currencies.add(new Currency("JPY", "Japanese Yen", 149.0));
        currencies.add(new Currency("AUD", "Australian Dollar", 1.56));
        currencies.add(new Currency("CAD", "Canadian Dollar", 1.36));
        currencies.add(new Currency("CHF", "Swiss Franc", 0.91));
        currencies.add(new Currency("CNY", "Chinese Yuan", 7.30));
    }

    // Get the list of currencies
    public List<Currency> getCurrencies() {
        return currencies;
    }

    // Convert an amount from one currency to another
    public double convert(double amount, Currency fromCurrency, Currency toCurrency) {
        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Currencies cannot be null.");
        }
        // Convert to fixed currency (e.g., USD) first, then to target currency
        double amountInUSD = amount / fromCurrency.getConversionRate();
        return amountInUSD * toCurrency.getConversionRate();
    }
}
