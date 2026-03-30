/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.util.regex.Pattern;
/**
 *
 * @author Maditsi Rapelego
 */
public class Login {

    private String storedUsername;
    private String storedPassword;
    private String storedCell;

    // Username validation
    public boolean checkUserName(String username) {

        if (username.contains("_") && username.length() <= 5) {
            return true;
        }

        return false;
    }

    // Password validation
    public boolean checkPasswordComplexity(String password) {

        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    // Phone validation
    public boolean checkCellPhoneNumber(String cell) {

        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cell);
    }

    // Register user
    public String registerUser(String username, String password, String cell) {

        if (!checkUserName(username)) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";

        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        }

        if (!checkCellPhoneNumber(cell)) {

            return "Cell phone number incorrectly formatted or does not contain international code.";

        }

        storedUsername = username;
        storedPassword = password;
        storedCell = cell;

        return "Cell phone number successfully added.";
    }

    // Login check
    public boolean loginUser(String username, String password) {

        return username.equals(storedUsername) && password.equals(storedPassword);

    }

    // Login status
    public String returnLoginStatus(boolean status, String firstName, String lastName) {

        if (status) {

            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";

        }

    }

}
