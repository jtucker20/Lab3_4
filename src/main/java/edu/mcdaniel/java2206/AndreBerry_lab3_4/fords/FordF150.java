package edu.mcdaniel.java2206.AndreBerry_lab3_4.fords;

import edu.mcdaniel.java2206.AndreBerry_lab3_4.car.VehicleAbstractClass;
import edu.mcdaniel.java2206.AndreBerry_lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.AndreBerry_lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.AndreBerry_lab3_4.security.*;
import edu.mcdaniel.java2206.AndreBerry_lab3_4.fords.FordF150;
import edu.mcdaniel.java2206.AndreBerry_lab3_4.vehicles.FordVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FordF150 extends VehicleAbstractClass implements Vehicle, WifiEnabledVehicle {

    //Private Assets
    private Logger log = LogManager.getLogger(FordF150.class);

    private double accelerationRate;
    private double distance;
    private String fordWifiPassword;

    private boolean lightsOn;

    //Constructors
    public FordF150() {
        super();
        setModel("F150");
        this.lightsOn = false;
    }

    @Override
    public String wreckReport() {
        return "This Vehicle has been in " + getNumberOfWrecks() + " wrecks.";
    }

    //Major Methods
    @Override
    public void accel(double percentOfMaxAccel) {
        this.accelerationRate = percentOfMaxAccel;
    }

    @Override
    public void brake(double percentOfMaxBrake) {
        this.accelerationRate = this.accelerationRate - percentOfMaxBrake;
    }

    @Override
    public void turnOnLights() {
        this.lightsOn = true;
    }

    @Override
    public void toggleLights() {
        this.lightsOn = !this.lightsOn;
    }

    @Override
    public String showLightsStatus() {
        return "The Lights are " + ((this.lightsOn) ? "On" : "Off");
    }

    @Override
    public String showVehicleState() {
        return "This Ford F150 has an acceleration of: " + this.accelerationRate
                + "\nThis Ford F150 has it's lights " + ((this.lightsOn) ? "On" : "Off");
    }

    @Override
    public String getWifiProvider() {
        return WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString();
    }

    @Override
    public String getNetworkName() {
        //a lazily created network name most likely implemented by someone with a lack of imagination.
        return "labNetwork";
    }

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(),
                this.getNetworkName(),
                this.fordWifiPassword);
    }

    //Getters
    public double getAccelerationRate() {
        return accelerationRate;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    @Override
    public void setWifiPassword(String password) {
        this.fordWifiPassword = password;

    }

}