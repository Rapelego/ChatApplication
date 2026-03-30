package TestClasses;

import chatapp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStudent {

    @Test
    public void testUsernameCorrect() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyle!!!!"));
    }

    @Test
    public void testPasswordCorrect() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&sec@ke99!"));
    }

    @Test
    public void testPasswordIncorrect() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellCorrect() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellIncorrect() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976");

        boolean result = login.loginUser("kyl_1", "Ch&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFail() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976");

        boolean result = login.loginUser("wrong", "wrong");
        assertFalse(result);
    }

    @Test
    public void testLoginStatusSuccess() {
        Login login = new Login();

        String message = login.returnLoginStatus(true, "Kyle", "Smith");

        assertEquals("Welcome Kyle, Smith it is great to see you again.", message);
    }

    @Test
    public void testLoginStatusFail() {
        Login login = new Login();

        String message = login.returnLoginStatus(false, "Kyle", "Smith");

        assertEquals("Username or password incorrect, please try again.", message);
    }
}