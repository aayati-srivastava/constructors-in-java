import java.util.Random;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // 1. Default constructor → balance = 0
    public BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
    }

    // 2. Constructor with name → assigns random account number
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
    }

    // 3. Constructor with name and initial balance
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
    }

    // Utility: Generate random account number
    private int generateAccountNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); // 6-digit account number
    }

    // Method: deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " successfully.");
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Method: withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Method: displayAccount
    public void displayAccount() {
        System.out.println("🏦 Bank Account Details");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("-------------------------");
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        // Using different constructors
        BankAccount acc1 = new BankAccount();  // Default
        BankAccount acc2 = new BankAccount("Aayati");  // Name only
        BankAccount acc3 = new BankAccount("Yatharth", 5000.0);  // Name + balance

        // Display initial accounts
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();

        // Perform transactions
        acc2.deposit(2000);
        acc2.withdraw(500);
        acc2.displayAccount();

        acc3.withdraw(6000); // Should fail due to insufficient balance
        acc3.deposit(1500);
        acc3.displayAccount();
    }
}
