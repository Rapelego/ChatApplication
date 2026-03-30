package chatapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        // USER DETAILS
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        // REGISTRATION
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell phone (+27...): ");
        String cell = input.nextLine();

        String registerMessage = login.registerUser(username, password, cell);
        System.out.println(registerMessage);

        // LOGIN
        System.out.print("Enter username to login: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password to login: ");
        String loginPass = input.nextLine();

        boolean loginStatus = login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus(loginStatus, firstName, lastName));
    }
}