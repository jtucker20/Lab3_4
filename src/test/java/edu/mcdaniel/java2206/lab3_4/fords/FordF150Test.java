package edu.mcdaniel.java2206.lab3_4.fords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FordF150Test {
    private FordF150 f150;

    @BeforeEach
    public void setUp(){
        this.f150 = new FordF150();
    }


    @Test
    void getWreckReportForFord() {
        //Arrange
        String expected = "";

        //Act
        String actual = this.f150.getWreckReportForFord().toString();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void accel() {
    }

    @Test
    void brake() {
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
    void getAccelerationRate() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void isLightsOn() {
    }

    @Test
    void gender() {
    }

    @Test
    void tone() {
    }

    @Test
    void getDirection() {
    }
}