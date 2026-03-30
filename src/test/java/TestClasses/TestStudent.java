/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import chatapp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
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

