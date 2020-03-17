package edu.mcdaniel.java2206.lab3_4.fords;

import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;
import edu.mcdaniel.java2206.lab3_4.fords.FordFocus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FordFocusTest {
    private FordFocus focus;

    @BeforeEach
    public void setUp(){
        this.focus = new FordFocus();
    }

    @Test
    void accel() {
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

        // Act
        this.focus.brake(50.0);

        //Assert
        System.out.println(this.focus.getAccelerationRate());
        assertEquals(expected, this.focus.getAccelerationRate());
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
    void getNetworkName() {
    }

    //@Test
    //void getToken() {
        //Arrange
        //String expected = "VE9ZT1RBX1ZFSElDTEVfV0lGSV9QUk9WSURFUmxhYk5ldHdvcmtwYXNzd29yZA==";
        //focus.setWifiPassword("password");

        //Act
        //Token token = focus.getToken();
        //token.generatokenString();

        // Assert
        //assertEquals(expected, token.getTokenString());
    // }

    @Test
    void getAccelerationRate() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void isLightsOn() {
    }
}