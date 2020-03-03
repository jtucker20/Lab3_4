package edu.mcdaniel.java2206.lab2.car;

import edu.mcdaniel.java2206.lab2.gravity.GravityBaseClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GravityBaseClassTest {

    private GravityBaseClass gravityBaseClassClass;

    @BeforeEach
    void setUp() {

        gravityBaseClassClass = new GravityBaseClass();

    }

    @Test
    void getMessage() {

        // Arrange
        String expected = "Hello World!";

        // Act
        String actual = gravityBaseClassClass.getMessage();

        // Assert
        assertEquals(expected, actual);
    }
}