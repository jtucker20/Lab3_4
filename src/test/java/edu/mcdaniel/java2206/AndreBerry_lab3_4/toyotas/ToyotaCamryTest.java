package edu.mcdaniel.java2206.AndreBerry_lab3_4.toyotas;

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
    void turnOnLights() {
    }

    @Test
    void toggleLights() {
    }

    @Test
    void testAccel() {
    }

    @Test
    void testBrake() {
    }

    @Test
    void testToggleLights() {
    }

    @Test
    void getToken()
    {
        //Arrange
        String expected = "";
        camry.setWifiPassword("password");

        //Act
       // Token token = camry.getToken();
       // token.generateTokenString();

        //Assert
        //assertEquals(expected, token.getTokenString());
    }
}