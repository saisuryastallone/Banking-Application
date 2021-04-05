import java.util.Scanner;

public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class Constructor
    Account(String custName, String custID) {
        customerName = custName;
        customerID = custID;
    }

    //Method for Depositing Money
    void Deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Method for Withdrawing Money
    void Withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //Method for Displaying Previous Transactions
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    //Method for calculating interest for current funds after a number of years
    void getInterest(int years) {
        double interestRate = 0.01;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current Interest Rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be " + newBalance);
    }

    //Method for displaying Main Menu
    void showMenu() {
        char option = '\0';
        char currency = '\u20AC';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = " + currency + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    Deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    Withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter the number of years to get accrued interest: ");
                    int years = scanner.nextInt();
                    getInterest(years);
                    break;
                case 'F':
                    System.out.println("==============================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter the right choice: ");
                    break;

            }

        } while (option != 'F');
        System.out.println("Thank you for banking with us!");


    }
}
