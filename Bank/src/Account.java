

class Account {
    private double balance;
    private String accountType;
    private String currency;
    private String currencySymbol;

    // constructor for account class
    public Account(String accountType, String currency, String currencySymbol) {
        this.accountType = accountType;
        this.currency = currency;
        this.currencySymbol = currencySymbol;
        this.balance = 0.0;
    }

    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + currencySymbol + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //  withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + currencySymbol + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // check balance
    public void checkBalance() {
        System.out.println("Current balance: " + currencySymbol + balance);
    }

    //  get the current balance
    public double getBalance() {
        return balance;
    }

    // get the currency symbol
    public String getCurrencySymbol() {
        return currencySymbol;
    }
}
