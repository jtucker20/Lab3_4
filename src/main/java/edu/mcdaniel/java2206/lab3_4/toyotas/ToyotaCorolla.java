package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.interfaces.SiriEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.TokenFactory;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;
import edu.mcdaniel.java2206.lab3_4.vehicles.ToyotaVehicle;

public class ToyotaCorolla extends ToyotaVehicle implements Vehicle, WifiEnabledVehicle, SiriEnabledVehicle {


    //Private Assets
    private double accelerationRate;
    private double distance;
    private String toyotaWifiPassword;
    private GenderEmun genderOfSiri;
    private ToneEnum toneOfVoice;


    private boolean lightsOn;
    private double lightsDimPercentage;

    //Constructors
    public ToyotaCorolla(){
        super();
        setModel("Corola");
        this.lightsOn = false;
    }

    @Override
    public String wreckReport() {
        return "This Vehicle has been in " + getNumberOfWrecks() + " wrecks.";

    }

    @Override
    public String getWreckReportForToyota() {
        return "This Vehicle has been in " + getNumberOfWrecks() + " wrecks.";

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

    //Minor Methods
    public void corollaLightsDim(double percentDimming){
        this.lightsDimPercentage = percentDimming;
        System.out.println("Corolla lights have been dimmed to " + this.lightsDimPercentage);

    }
    @Override
    public String getWifiProvider() {
        return WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString();

    }

    @Override
    public String getNetworkName() {
        return "labNetwork";
    }

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(),
                this.getNetworkName(),
                this.toyotaWifiPassword);
    }

    @Override
    public void setWifiPassword(String password) {
        this.toyotaWifiPassword = password;

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
    public void gender(String genderOfSiri) {
        if(genderOfSiri.toLowerCase().equals("female") ){
            this.genderOfSiri = GenderEmun.FEMALE;
        }
        if(genderOfSiri.toLowerCase().equals("male")){
            this.genderOfSiri = GenderEmun.MALE;
        }

    }

    @Override
    public void tone(String toneOfVoice) {
        if(toneOfVoice.toLowerCase().equals("female")){
            this.toneOfVoice = ToneEnum.HIGH_PITCH_VOICE;
        }
        if(toneOfVoice.toLowerCase().equals("male")){
            this.toneOfVoice = ToneEnum.DEEP_VOICE;
        }
    }

    @Override
    public String[] getDirection() {
        String[] directions = new String[3];
        directions[0] = "'Turn Right!' Says a " + this.toneOfVoice.toString() + " " + this.genderOfSiri + " Siri Voice.";
        directions[1] = "'Turn Left!' Says a "  + this.toneOfVoice.toString() + " " + this.genderOfSiri + " Siri Voice.";
        directions [2] = "'Turn Go Straight!' Says a "  + this.toneOfVoice.toString() + " " + this.genderOfSiri + " Siri Voice.";



        return directions;
    }
}


