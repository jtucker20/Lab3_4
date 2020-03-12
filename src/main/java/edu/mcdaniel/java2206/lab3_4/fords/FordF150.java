package edu.mcdaniel.java2206.lab3_4.fords;

import edu.mcdaniel.java2206.lab3_4.car.VehicleAbstractClass;
import edu.mcdaniel.java2206.lab3_4.interfaces.VehicleWithMapping;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.TokenFactory;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;

public class FordF150 extends VehicleAbstractClass implements Vehicle, WifiEnabledVehicle, VehicleWithMapping {

    //Private Assets
    private double accelerationRate;
    private double distance;
    private String fordWifiPassword;
    private boolean lightsOn;
    private double x1, y1,x2, y2;

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
    public String getWifiProvider() {
        return WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString();
    }

    @Override
    public String getNetworkName() {
        return "labNetwork";
    }

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(), this.getNetworkName(), this.fordWifiPassword);
    }

    @Override
    public void setWifiPassword(String password) {

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
            return msg + (Math.sqrt(Math.pow((this.x1 - this.x2), 2) + Math.pow((this.y1 - this.y2), 2)) / this.accelerationRate) + " units of time";

        }
        else
        {
            return "You're going nowhere fast!";
        }
    }
}
