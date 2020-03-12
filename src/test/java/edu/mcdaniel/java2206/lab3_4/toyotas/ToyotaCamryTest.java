package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;
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
    void getWifiProvider() {
        //Arrange
        String expected = WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString();

        //Act
        String actual =
    }

    @Test
    void getNetworkName() {
    }

    @Test
    void getToken() {
        //Arrange
        camry.setWifiPassword("password");

        //Act
        Token tokon = camry.getToken();
        Token token = new Token();
        token.generatokenString();

       // Assert
        assertEquals(expected, token.getTokenString());
    }
}