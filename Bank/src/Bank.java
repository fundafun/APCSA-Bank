

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // welcome message
        System.out.println("Welcome to a not very suspicious bank in the Cayman Islands!");



        // currency symbol mapping -> special keyboard
        Map<String, String> currencySymbols = new HashMap<>();
        currencySymbols.put("USD", "$");
        currencySymbols.put("EUR", "€");
        currencySymbols.put("GBP", "£");
        currencySymbols.put("CAD", "C$");
        currencySymbols.put("AUD", "A$");
        currencySymbols.put("JPY", "¥");
        currencySymbols.put("INR", "₹");

        // ask for the currency
        System.out.print("Please enter your preferred currency (USD, EUR, GBP, CAD, AUD, JPY, INR): ");
        String currency = scanner.nextLine().toUpperCase();  // input to uppercase for consistency

        // validate currency
        while (!currencySymbols.containsKey(currency)) {
            System.out.println("Invalid currency. Please enter a valid currency (e.g., USD, EUR, GBP, CAD, AUD, JPY, INR): ");
            currency = scanner.nextLine().toUpperCase();
        }

        String accountType;

        // account type
        while (true) {
            System.out.print("Enter account type (savings/checking): ");
            accountType = scanner.nextLine().toLowerCase();  // Convert input to lowercase to avoid case sensitivity

            // check account type input
            if (accountType.equals("savings") || accountType.equals("checking")) {
                break;  // valid input will exit the loop
            } else {
                System.out.println("Invalid account type. Please enter 'savings' or 'checking'.");
            }
        }

        // create the account based on the user input
        Account account = new Account(accountType, currency, currencySymbols.get(currency));
        System.out.println("You have created a " + accountType + " account in " + currency + ".");

        boolean exit = false;
        while (!exit) {
            // menu options
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a valid number.");
                        scanner.next(); // clear invalid input
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        // enough balance to withdraw
                        if (withdrawAmount > account.getBalance()) {
                            System.out.println("Insufficient balance. You currently have " + account.getBalance() + " " + account.getCurrencySymbol() + ".");
                        } else {
                            account.withdraw(withdrawAmount);
                        }
                    } else {
                        System.out.println("Invalid amount. Please enter another number.");
                        scanner.next(); // clear invalid input
                    }
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Current Balance: " + account.getBalance() + " " + account.getCurrencySymbol() + ".");
                    System.out.println("Thank you for using a not very suspicious bank in the Cayman Islands. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
            }
        }
        scanner.close();
    }
}

