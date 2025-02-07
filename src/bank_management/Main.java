package bank_management;
import java.util.Scanner;

public class Main {
    static Scanner sc;
    static String username;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        username = UtilityMethods.getCharInput(sc, "\nHi, May I know your name please?");

        stylishBanner();
        
        System.out.println("\nHow may I help you? Please enter the number of your choice.");
        
        EventHandlers.promptWelcome();
    }

    public static void stylishBanner() throws InterruptedException {
    	// Stylish Banner for the bank management system.
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("|| BANK ACCOUNT MANAGEMENT SYSTEM  ||");
        System.out.println("=====================================");
        System.out.printf("         [WELCOME %s!]          \n", username);
        Loadings.mainLoading(5);
        
    }
}
