package task3;

import java.util.Scanner;

public class CurrencyConverter{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        double usdToEurRate = 0.85; 
        double eurToUsdRate = 1.18; 
        double usdToInrRate = 74.5; 
        double eurToInrRate = 87.4; 

        
        System.out.print("Enter the base currency (USD, EUR, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = 0;
        
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            convertedAmount = amount * usdToEurRate;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            convertedAmount = amount * eurToUsdRate;
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("INR")) {
            convertedAmount = amount * usdToInrRate;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("INR")) {
            convertedAmount = amount * eurToInrRate;
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
            convertedAmount = amount / usdToInrRate;
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("EUR")) {
            convertedAmount = amount / eurToInrRate;
        } else {
            System.out.println("Conversion rate not available for the selected currencies.");
            scanner.close();
            return;
        }

        System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }
}
