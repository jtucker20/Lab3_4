package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.interfaces.VehicleWithMapping;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.*;
import edu.mcdaniel.java2206.lab3_4.vehicles.ToyotaVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToyotaCamry extends ToyotaVehicle implements Vehicle, WifiEnabledVehicle, VehicleWithMapping {

    //Private Assets
    private Logger log = LogManager.getLogger(ToyotaCamry.class);

    private double accelerationRate;
    private double distance;
    private String toyotaWifiPassword;
    private boolean lightsOn;
    private double x1, y1,x2, y2;

    //Constructors
    public ToyotaCamry(){
        super();
        setModel("Camry");
        this.lightsOn = false;
    }

    //Major Methods
    @Override
    public String wreckReport() {
        return "This Vehicle has been in " + getNumberOfWrecks() + " wrecks.";
    }

    @Override
    public String getWreckReportForToyota() {
        return "This Toyota has been in " + getNumberOfWrecks() + " wrecks.";
    }

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
        return "This Camry has an acceleration of: " + this.accelerationRate
                + "\nThis Camry has it's lights " + ((this.lightsOn) ? "On" : "Off");
    }
    //Getters
    @Override
    public String getWifiProvider() {
        return WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString();
    }

    @Override
    public String getNetworkName() {
        //I was too lazy to customize the name of the network.  USE THIS FOR ALL
        // OF THE NETWORKS YOU HAVE TO IMPLEMENT!!
        return "labNetwork";
    }

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(),
                                     this.getNetworkName(),
                                     this.toyotaWifiPassword);
    }

    public double getAccelerationRate() {
        return accelerationRate;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    //Setters
    @Override
    public void setWifiPassword(String password){
        this.toyotaWifiPassword = password;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x1 = x;
        this.y1 = y;
    }
    public double[] getLocation()
    {
        double[] location = {this.x1, this.x2};
        return location;
    }

    @Override
    public void setDestination(double x, double y) {
        this.x2 = x;
        this.y2 = y;
    }

    @Override
    public String findNearby(pitStops pitStop) {
        return "There's a " + pitStop + " on your left in 0.5 miles.";
    }

    @Override
    public String getETA() {
        if (this.accelerationRate > 0) {
            String msg = "At the present speed, you will arrive in approximately ";
            return msg + (Math.sqrt(Math.pow((this.x1 - this.x2), 2) + Math.pow((this.y1 - this.y2), 2)) / this.accelerationRate) + " units of time.";

        }
        else
        {
            return "You're going nowhere fast!";
        }
    }
}
