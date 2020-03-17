package edu.mcdaniel.java2206.lab3_4.fords;

import edu.mcdaniel.java2206.lab3_4.car.VehicleAbstractClass;
import edu.mcdaniel.java2206.lab3_4.interfaces.SiriEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.TokenFactory;
import edu.mcdaniel.java2206.lab3_4.security.WifiProviderName;
import edu.mcdaniel.java2206.lab3_4.toyotas.GenderEmun;
import edu.mcdaniel.java2206.lab3_4.toyotas.ToneEnum;
import edu.mcdaniel.java2206.lab3_4.toyotas.ToyotaCamry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FordF150 extends VehicleAbstractClass implements Vehicle, WifiEnabledVehicle, SiriEnabledVehicle {
    //Private Assets
    private Logger log = LogManager.getLogger(ToyotaCamry.class);

    private double accelerationRate;
    private double distance;
    private String fordWifiPassword;
    private GenderEmun genderOfSiri;
    private ToneEnum toneOfVoice;

    private boolean lightsOn;

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

    public String getWreckReportForFord(){
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
    public String  getWifiProvider() {
        return WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString();
    }

    @Override
    public String getNetworkName() {
        return "labNetwork";
    }

    @Override
    public Token getToken() {
        return TokenFactory.getToken(this.getWifiProvider(),
                this.getNetworkName(),
                this.fordWifiPassword);
    }

    @Override
    public void setWifiPassword(String password) {
        this.fordWifiPassword = password;
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
        directions [2] = "'Turn Go Straight!' Says a "  + this.toneOfVoice.toString() + " " + this.genderOfSiri + " Siri Voice.";



        return directions;
    }
}
