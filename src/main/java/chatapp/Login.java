/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.util.regex.Pattern;
/**
 * Login class handles:
 * - Username validation
 * - Password validation
 * - Cell phone validation
 * - User registration
 * - Login verification
 * 
 * @author Maditsi Rapelego
 */
public class Login {
    // Variables to store user details after registration
    private String storedUsername;
    private String storedPassword;
    private String storedCell;

    /**
     * Validates the username.
     * Username must:
     * - Contain an underscore (_)
     * - Be no longer than 5 characters
     */
    public boolean checkUserName(String username) {

        if (username.contains("_") && username.length() <= 5) {
            return true;
        }

        return false;
    }

    /**
     * Password validation
     * Password must:
     * - Be at least 8 characters long
     * - Contain at least one uppercase letter
     * - Contain at least one number
     * - Contain at least one special character
     */
    public boolean checkPasswordComplexity(String password) {

        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    /**
     * Validates South African cell phone number format.
     * Must:
     * - Start with +27
     * - Be followed by 9 digits
     */
    public boolean checkCellPhoneNumber(String cell) {

        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cell);
    }

    // Register user
    public String registerUser(String username, String password, String cell) {
//Check Username
        if (!checkUserName(username)) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";

        }

        //Check password
        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        }

        //check cellphone number
        if (!checkCellPhoneNumber(cell)) {

            return "Cell phone number incorrectly formatted or does not contain international code.";

        }

        //Store user details after successful vilidation
        storedUsername = username;
        storedPassword = password;
        storedCell = cell;

        return "Cell phone number successfully added.";
    }

    /**
     * Registers a user if all validations pass.
     * Stores username, password, and cell number.
     * Returns appropriate message based on validation results.
     */
    public boolean loginUser(String username, String password) {

        return username.equals(storedUsername) && password.equals(storedPassword);

    }

    // Returns a message based on login success or failure.
    public String returnLoginStatus(boolean status, String firstName, String lastName) {

        if (status) {

            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";

        }

    }

}
