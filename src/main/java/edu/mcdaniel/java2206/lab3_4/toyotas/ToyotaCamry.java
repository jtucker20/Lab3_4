package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.interfaces.GPSVehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.*;
import edu.mcdaniel.java2206.lab3_4.vehicles.ToyotaVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToyotaCamry extends ToyotaVehicle implements Vehicle, WifiEnabledVehicle, GPSVehicle {

    //Private Assets
    private Logger log = LogManager.getLogger(ToyotaCamry.class);

    private double accelerationRate;
    private double timeTraveled;
    private double mph;
    private double distance;
    private double startTime;
    private double arrivalTime;
    private String toyotaWifiPassword;

    private boolean lightsOn;

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

    @Override
    public void timeTraveled()
    {
        this.timeTraveled = distance/mph;
    }

    @Override
    public void arrivalTime()
    {
        arrivalTime = startTime + timeTraveled;
    }

    @Override
    public double getMph()
    {
        return mph;
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
        this.toyotaWifiPassword = password;
    }
}
