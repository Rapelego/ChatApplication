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

    // Variables to store registered user details
    private String storedUsername;
    private String storedPassword;
    private String storedCell;

    /**
     * Validates username.
     * Username must:
     * - Contain an underscore (_)
     * - Be no longer than 5 characters
     */
    public boolean checkUserName(String username) {

        return username.contains("_") && username.length() <= 5;

    }

    /**
     * Validates password complexity.
     * Password must:
     * - Be at least 8 characters long
     * - Contain an uppercase letter
     * - Contain a number
     * - Contain a special character
     */
    public boolean checkPasswordComplexity(String password) {

        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;

    }

    /**
     * Validates South African cellphone number.
     * Number must:
     * - Start with +27
     * - Contain 9 digits after +27
     */
    public boolean checkCellPhoneNumber(String cell) {

        String regex = "^\\+27[0-9]{9}$";

        return Pattern.matches(regex, cell);

    }

    /**
     * Registers a user if all validations pass.
     * Stores user details.
     */
    public String registerUser(String username,
                               String password,
                               String cell) {

        // Validate username
        if (!checkUserName(username)) {

            return "Username is not correctly formatted; "
                    + "please ensure that your username contains "
                    + "an underscore and is no more than "
                    + "five characters in length.";

        }

        // Validate password
        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted; "
                    + "please ensure that the password contains "
                    + "at least eight characters, a capital letter, "
                    + "a number, and a special character.";

        }

        // Validate cellphone number
        if (!checkCellPhoneNumber(cell)) {

            return "Cell phone number incorrectly formatted "
                    + "or does not contain international code.";

        }

        // Store validated user details
        storedUsername = username;
        storedPassword = password;
        storedCell = cell;

        return "User successfully registered.";

    }

    /**
     * Verifies login details.
     * Returns true if username and password match.
     */
    public boolean loginUser(String username, String password) {

        return username.equals(storedUsername)
                && password.equals(storedPassword);

    }

    /**
     * Returns login result message.
     */
    public String returnLoginStatus(boolean status,
                                    String firstName,
                                    String lastName) {

        if (status) {

            return "Welcome "
                    + firstName
                    + ", "
                    + lastName
                    + " it is great to see you again.";

        } else {

            return "Username or password incorrect, "
                    + "please try again.";

        }

    }
}