
 // Program to Simulate an ATM
 // Handles deposits and withdrawals with balance checks.
 
class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        System.out.println("Withdraw amount is : " + amount);
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        System.out.println("State of Chennai\n");
        
        BankAccount account = new BankAccount("User", "12345", 700.0);
        
        account.displayBalance();
        
        account.deposit(200.0);
        account.displayBalance();
        
        account.withdraw(100.0);
        account.displayBalance();
        
        account.withdraw(1000.0);
    }
}