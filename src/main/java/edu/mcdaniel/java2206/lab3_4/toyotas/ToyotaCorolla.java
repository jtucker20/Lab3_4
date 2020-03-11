package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.TokenFactory;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;
import edu.mcdaniel.java2206.lab3_4.vehicles.ToyotaVehicle;

public class ToyotaCorolla extends ToyotaVehicle implements Vehicle, WifiEnabledVehicle {


    //Private Assets
    private double accelerationRate;
    private double distance;

    private boolean lightsOn;
    private double lightsDimPercentage;

    private String corollaWifiPassword;

    //Constructors
    public ToyotaCorolla(){
        super();
        setModel("Corolla");
        this.lightsOn = false;
    }

    @Override
    public String wreckReport() {
        return null;
    }

    @Override
    public String getWreckReportForToyota() {
        return null;
    }


    //Major Methods
    @Override
    public void accel(double percentOfMaxAccel) {
        this.accelerationRate = 0.80 * percentOfMaxAccel;
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
        if(this.lightsOn) {
            return "The lights are On.";
        } else {
            return "The lights are Off.";
        }
    }

    @Override
    public String showVehicleState() {

        return "This Corolla has an acceleration of: " + this.accelerationRate
                + "\nThis Corolla has it's lights " + ((this.lightsOn) ? "On" : "Off");
    }

    @Override
    public String getWifiProvider() {return WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString();}

    @Override
    public String getNetworkName(){return "labNetwork";}

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(),
                this.getNetworkName(),
                this.corollaWifiPassword);
    }

    //Minor Methods
    public void corollaLightsDim(double percentDimming){
        this.lightsDimPercentage = percentDimming;
        System.out.println("Corolla lights have been dimmed to " + this.lightsDimPercentage);

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

    public double getLightsDimPercentage() {
        return lightsDimPercentage;
    }

    @Override
    public void setWifiPassword(String password) {this.corollaWifiPassword = "r0yalArmour";}
}
