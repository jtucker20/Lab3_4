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
    void timeTraveled(){
        //Arrange
        double expected = 30.0;

        //Act
        this.camry.timeTraveled();

        //Assert
        assertEquals(30.0, this.camry.timeTraveled());

    }

    @Test
    void arrivalTime(){
        //Arrange
        double expected = 10.00;

        //Act
        this.camry.arrivalTime();

        //Assert
        assertEquals(10.00, this.camry.arrivalTime());

    }

    @Test
    double getMph(){

    }

}