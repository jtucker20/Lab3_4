package edu.mcdaniel.java2206.lab3_4.fords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FordF150Test {

    private FordF150 F150;

    @BeforeEach
    void setUp() {
        this.F150 = new FordF150();
    }

    @Test
    void wreckReport() {
        //Arrange
        String expected = "";

        //Act
        this.F150.wreckReport();

        //Assert
        assertEquals(expected, this.F150.wreckReport());
    }

    @Test
    void accel() {
        //Arrange
        double expected = 70.0;

        //Act
        this.F150.accel(70.0);

        //Assert
        assertEquals(expected, this.F150.getAccelerationRate());
    }

    @Test
    void brake() {
        //Arrange
        double expected = -50.0;

        //Act
        this.F150.brake(50.0);

        //Assert
        assertEquals(expected, this.F150.getAccelerationRate());
    }


    @Test
    void showVehicleState() {
        //Arrange
        String expected = "This vehicle has an acceleration of: 0.0\n" +
                "This vehicle has it's lights Off\n" +
                "This vehicle's time traveled is 0.0";

        //Act
        String actual = this.F150.showVehicleState();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getWifiProvider() {
        //Arrange
        String expected  = "";

        //Act
        String actual = F150.getWifiProvider();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getNetworkName() {
        //Arrange
        String expected  = "";

        //Act
        String actual = F150.getNetworkName();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getToken() {
        //Arrange
        String expected = "";

        //Act
        F150.getToken();

        //Assert
        assertEquals(expected, F150.getToken());
    }

    @Test
    void setWifiPassword() {
        //Arrange
        String expected  = "";

        //Act
        F150.setWifiPassword();

        //Assert
        assertEquals(expected, F150.setWifiPassword());
    }
}