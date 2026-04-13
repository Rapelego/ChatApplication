package chatapp;

import java.util.Scanner;

/**
 * Main class for running the Login Application.
 * Handles user input, validation, and login process.
 */
public class Main {

    public static void main(String[] args) {

        // Scanner object to read user input from console
        Scanner input = new Scanner(System.in);
         // Create Login object to access validation and login methods
        Login login = new Login();

        // REGISTRATION SECTION//
        System.out.println("===== REGISTRATION =====");
        
        //Get user's first name
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        
        // Get user's last name
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

          // Get username input
        System.out.print("Enter username: ");
        String username = input.nextLine();

        // Username check
        if (login.checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }
        
        //Get Password input
        System.out.print("Enter password: ");
        String password = input.nextLine().trim();// trim removes extra spaces

        // Password check
        if (login.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        //Get cellphone input
        System.out.print("Enter cell phone (+27...): ");
        String cell = input.nextLine();

        // Cell check
        if (login.checkCellPhoneNumber(cell)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }
        // Store user details AFTER validation
        login.registerUser(username, password, cell);

        // LOGIN SECTION
        System.out.println("\n===== LOGIN =====");

        // LoginUsername
        System.out.print("Enter username: ");
        String loginUser = input.nextLine().trim();

        //login password
        System.out.print("Enter password: ");
        String loginPass = input.nextLine().trim();

        // Check if login details match stored user
        boolean status = login.loginUser(loginUser, loginPass);

       // Display login result message
        System.out.println(login.returnLoginStatus(status, firstName, lastName));

    }
}