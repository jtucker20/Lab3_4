package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.interfaces.VehicleWithMapping;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String actual = camry.getWifiProvider();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getNetworkName() {
    }

    @Test
    void getToken() {

        camry.setWifiPassword("password");

        Object obj =camry.getToken();

        assertTrue(obj instanceof Token); //"Masquerading" as class or interface -- "polymorphism when masquerading as another object"
        //Token tkn = Mockito.mock
    }

    @Test
    void setWifiPassword() {
    }

    @Test
    void setLocation() {
        camry.setLocation(0,0);
        double[] expected = {0.0, 0.0};
        double[] actual = camry.getLocation();
        for(int i = 0; i < actual.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    //Did not create a test for setDestination because it would be identical

    @Test
    void getETA() {
        camry.setLocation(0,0);
        camry.setDestination(10, 0);
        camry.accel(1);
        String msg = "At the present speed, you will arrive in approximately ";
        double time = 10.0;
        String expected = msg + time + " units of time.";
        assertEquals(expected, camry.getETA());

        camry.brake(1);
        expected = "You're going nowhere fast!";
        assertEquals(expected, camry.getETA());
    }

    @Test
    void findNearby() {
        String pitStop = "RESTAURANT";
        String expected = "There's a " + pitStop + " on your left in 0.5 miles.";
        assertEquals(expected, camry.findNearby(VehicleWithMapping.pitStops.RESTAURANT));
    }
}