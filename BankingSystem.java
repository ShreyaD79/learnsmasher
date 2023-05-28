import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: " + balance);
        } else {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful. Current balance: " + balance);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", "John Doe", 1000.0);
        BankAccount account2 = new BankAccount("654321", "Jane Smith", 500.0);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n** Banking System Menu **");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Account Holder: " + account1.getAccountHolderName());
                    System.out.println("Account Number: " + account1.getAccountNumber());
                    System.out.println("Balance: " + account1.getBalance());
                    break;
                case 4:
                    System.out.print("Enter the recipient's account number: ");
                    String recipientAccountNumber = scanner.next();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    if (account2.getAccountNumber().equals(recipientAccountNumber)) {
                        account1.transfer(account2, transferAmount);
                    } else {
                        System.out.println("Invalid recipient account number.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}