package edu.mcdaniel.java2206.lab3_4.toyotas;

import edu.mcdaniel.java2206.lab3_4.interfaces.SiriEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.*;
import edu.mcdaniel.java2206.lab3_4.vehicles.ToyotaVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToyotaCamry extends ToyotaVehicle implements Vehicle, WifiEnabledVehicle, SiriEnabledVehicle {

    //Private Assets
    private Logger log = LogManager.getLogger(ToyotaCamry.class);

    private double accelerationRate;
    private double distance;
    private String toyotaWifiPassword;

    private boolean lightsOn;
    private GenderEmun genderOfSiri;
    private ToneEnum toneOfVoice;


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
        return "This Vehicle has been in " + getNumberOfWrecks() + " wrecks.";
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
    public String  getWifiProvider() {
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
    public void setWifiPassword(String password){
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


    @Override
    public String gender(String genderOfSiri) {
        if(genderOfSiri.toLowerCase().equals("female") ){
            this.genderOfSiri = GenderEmun.FEMALE;
        }
        if(genderOfSiri.toLowerCase().equals("male")){
            this.genderOfSiri = GenderEmun.MALE;
        }

        return genderOfSiri;
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
        directions [2] = "'Go Straight!' Says a "  + this.toneOfVoice.toString() + " " + this.genderOfSiri + " Siri Voice.";



        return directions;
    }
}
