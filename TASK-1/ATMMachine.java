import java.util.Scanner;

public class ATMMachine {
    private static double balance = 1000.0;  // Initial balance
    private static final int PIN = 1234;      // Static PIN for simplicity

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN. Exiting.");
            return;
        }

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1) Check Balance");
            System.out.println("2) Withdraw");
            System.out.println("3) Deposit");
            System.out.println("4) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Please take your cash. Your new balance is: $" + balance);
        } else {
            System.out.println("Insufficient funds. Your balance is: $" + balance);
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }
}
