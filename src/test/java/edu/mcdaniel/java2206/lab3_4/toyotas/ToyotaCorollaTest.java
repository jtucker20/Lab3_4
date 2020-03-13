package edu.mcdaniel.java2206.lab3_4.toyotas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyotaCorollaTest {

    private ToyotaCorolla corolla;

    @BeforeEach
    public void setUp(){
        this.corolla = new ToyotaCorolla();
    }

    @Test
    void wreckReport() {
        //Arrange
        String expected = "";

        //Act
        this.corolla.wreckReport();

        //Assert
        assertEquals(expected, this.corolla.wreckReport());
    }

    @Test
    void getWreckReportForToyota() {
        //Arrange
        String expected = "";

        //Act
        this.corolla.getWreckReportForToyota();

        //Assert
        assertEquals(expected, this.corolla.getWreckReportForToyota());
    }

    @Test
    void accel() {
        //Arrange
        double expected = 0.0;

        //Act
        this.corolla.accel(0.0);

        //Assert
        assertEquals(expected, this.corolla.getAccelerationRate());
    }

    @Test
    void brake() {
        //Arrange
        double expected = -50.0;

        //Act
        this.corolla.brake(50.0);

        //Assert
        assertEquals(expected, this.corolla.getAccelerationRate());
    }

    @Test
    void showVehicleState() {
        //Arrange
        String expected = "This vehicle has an acceleration of: 0.0\n" +
                "This vehicle has it's lights Off\n" +
                "This vehicle's time traveled is 0.0";

        //Act
        String actual = this.corolla.showVehicleState();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getWifiProvider() {
    }

    @Test
    void getNetworkName() {
    }

    @Test
    void getToken() {
    }

    @Test
    void setWifiPassword() {
    }
}