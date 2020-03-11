package edu.mcdaniel.java2206.lab3_4.fords;

import edu.mcdaniel.java2206.lab3_4.car.VehicleAbstractClass;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.TokenFactory;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;

public class FordF150 extends VehicleAbstractClass implements Vehicle, WifiEnabledVehicle {

    //Private Assets
    private double accelerationRate;
    private double distance;

    private boolean lightsOn;

    private String f150WifiPassword;
    // I like to set each password to be a different variable name in order to keep it straight in my head
    //Constructors
    public FordF150(){
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
        return "The Lights are " + ( (this.lightsOn) ? "On" : "Off");
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
    public String getNetworkName() {return "labNetwork"; }

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(),
                this.getNetworkName(),
                this.f150WifiPassword);
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
    public void setWifiPassword(String password){
        this.f150WifiPassword = "Ting1e";
    }
}
