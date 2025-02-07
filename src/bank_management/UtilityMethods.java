package bank_management;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class UtilityMethods {

    public static int getIntInput(Scanner sc, String prompt) {
        int input = -1;
        while (true) {
            System.out.print(prompt);
            try {
                input = sc.nextInt();
                sc.nextLine();  // Consume the newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter a valid choice number from above: ");
                sc.next(); // Clear the invalid input
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Exiting.");
                System.exit(0);
            }
        }
        return input;
    }

    public static String getCharInput(Scanner sc, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                input = sc.nextLine();
                if (input.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("\nPlease enter a valid name containing only alphabetic characters and spaces");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Exiting.");
                System.exit(0);
            }
        }
        return input;
    }

    public static String getCharInputAccountNumber(Scanner sc, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                if (!sc.hasNextLine()) {
                    System.out.println("Exiting.");
                    System.exit(0);
                }
                input = sc.nextLine();
                if (input.matches("[0-9]+")) {
                    break;
                } else {
                    System.out.println("\nPlease enter a valid account number containing only digits.");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Exiting.");
                System.exit(0);
            }
        }
        return input;
    }

    public static BigDecimal getBigDecimalInput(Scanner sc, String prompt) {
        BigDecimal input = BigDecimal.valueOf(-1);
        while (true) {
            System.out.print(prompt);
            try {
                input = sc.nextBigDecimal();
                sc.nextLine();  // Consume the newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter a valid number: ");
                sc.next(); // Clear the invalid input
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Exiting.");
                System.exit(0);
            }
        }
        return input;
    }
}
