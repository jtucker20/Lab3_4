package edu.mcdaniel.java2206.lab3_4.toyotas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToyotaCamryTest {

    private ToyotaCamry camry;

    @BeforeEach
    public void setUp(){
        this.camry = new ToyotaCamry();
    }

    @Test
    void wreckReport() {
    }

    @Test
    void getWreckReportForToyota() {
    }

    @Test
    void accel() {
        //Arrange
        double expected = 70.0;

        //Act
        this.camry.accel(70.0);

        //Assert
        assertEquals(expected, this.camry.getAccelerationRate());
    }

    @Test
    void brake() {
        //Arrange
        double expected = -50.0;

        // Act
        this.camry.brake(50.0);

        //Assert
        System.out.println(this.camry.getAccelerationRate());
        assertEquals(expected, this.camry.getAccelerationRate());
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

    @Test
    void timeTraveled(){

    }

    @Test
    void arrivalTime(){

    }

    @Test
    double getMph(){

    }

}