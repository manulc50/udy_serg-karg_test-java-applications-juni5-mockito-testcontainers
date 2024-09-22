package com.mlorenzo.estore.service;

import com.mlorenzo.estore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init() {
        // Arrange
        userService = new UserServiceImpl();
        firstName = "John";
        lastName = "Doe";
        email = "johndoe@test.com";
        password = "12345678";
        repeatPassword = "12345678";
    }

    @DisplayName("User object created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        // Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertNotNull(user, "the createUser() should not have returned null");
        assertEquals(firstName, user.getFirstName(), "User's first name is incorrect");
        assertEquals(lastName, user.getLastName(), "User's last name is incorrect");
        assertEquals(email, user.getEmail(), "User's email is incorrect");
        assertNotNull(user.getId(), "User id is missing");
    }

    // En la etapa de refactorización de TDD, los tests de abajos comentados se eliminarían porque, al ser el código
    // idéntico al código del test de arriba excepto las aserciones, podemos unir los tests en uno solo pasando las
    // aserciones de los tests de abajo al test de arriba.
    /*@Test
    void testCreateUser_whenUserCreated_returnedUserObjectContainsSameFirstName() {
        // Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "John";
        String lastName = "Doe";
        String email = "jhondoe@test.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        // Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertEquals(firstName, user.getFirstName(), "User's first name is incorrect");
    }*/

    /*@Test
    void testCreateUser_whenUserCreated_returnedUserObjectContainsSameLastName() {
        // Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "John";
        String lastName = "Doe";
        String email = "jhondoe@test.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        // Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertEquals(lastName, user.getLastName(), "User's last name is incorrect");
    }*/

    /*@Test
    void testCreateUser_whenUserCreated_returnedUserObjectContainsSameEmail() {
        // Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "John";
        String lastName = "Doe";
        String email = "jhondoe@test.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        // Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertEquals(email, user.getEmail(), "User's email is incorrect");
    }*/

    /*@Test
    void testCreateUser_whenUserCreated_returnedUserObjectContainsGeneratedId() {
        // Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "John";
        String lastName = "Doe";
        String email = "jhondoe@test.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        // Act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertNotNull(user.getId(), "User id is missing");
    }*/

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        String firstName = "";
        String expectedExceptionMessage = "User's first name is empty";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                        userService.createUser(firstName, lastName, email, password, repeatPassword),
                "empty first name should have caused an Illegal Argument Exception");

        // Assert
        assertEquals(expectedExceptionMessage, exception.getMessage(), "exception error message is not correct");
    }

    @DisplayName("Empty last name causes correct exception")
    @Test
    void testCreateUser_whenLastNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        String lastName = "";
        String expectedExceptionMessage = "User's last name is empty";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(firstName, lastName, email, password, repeatPassword),
                "empty last name should have caused an Illegal Argument Exception");

        // Assert
        assertEquals(expectedExceptionMessage, exception.getMessage(), "exception error message is not correct");
    }
}
