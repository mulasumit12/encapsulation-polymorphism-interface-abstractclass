import java.util.*;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

// CurrentAccount subclass implementing Loanable
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;
    private double loanLimit = 50000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= loanLimit && calculateLoanEligibility()) {
            System.out.println("Loan Approved for: " + amount);
        } else {
            System.out.println("Loan Application Denied.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance > 10000;
    }
}

// Main class to test the banking system
public class BankingSystemTest {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("S123", "Alice", 20000));
        accounts.add(new CurrentAccount("C456", "Bob", 30000));

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println("Interest Earned: " + account.calculateInterest());

            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(20000);
            }
            System.out.println();
        }
    }
}
