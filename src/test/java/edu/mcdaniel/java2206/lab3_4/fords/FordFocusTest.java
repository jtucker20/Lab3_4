package edu.mcdaniel.java2206.lab3_4.fords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FordFocusTest {

    private FordFocus focus;

    @BeforeEach
    void setUp() {
        this.focus = new FordFocus();
    }

    @Test
    void wreckReport() {
        //Arrange
        String expected = "";

        //Act
        this.focus.wreckReport();

        //Assert
        assertEquals(expected, this.focus.wreckReport());
    }

    @Test
    void accel() {
        //Arrange
        double expected = 70.0;

        //Act
        this.focus.accel(70.0);

        //Assert
        assertEquals(expected, this.focus.getAccelerationRate());
    }

    @Test
    void brake() {
        //Arrange
        double expected = -50.0;

        //Act
        this.focus.brake(50.0);

        //Assert
        assertEquals(expected, this.focus.getAccelerationRate());
    }

    @Test
    void turnOnLights() {
    }

    @Test
    void toggleLights() {
    }

    @Test
    void showLightsStatus() {
    }

    @Test
    void showVehicleState() {
        //Arrange
        String expected = "This vehicle has an acceleration of: 0.0\n" +
                "This vehicle has it's lights Off\n" +
                "This vehicle's time traveled is 0.0";

        //Act
        String actual = this.focus.showVehicleState();

        //Assert
        assertEquals(expected, actual);
    }
}