package edu.mcdaniel.java2206.lab3_4.security;

import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;

import java.util.Base64;

public class Token {

    //Private Assets
    private String wifiProviderName;
    private String wifiNetworkName;
    private String wifiPassword;
    private String tokenString;

    private static final String base64Password = "bGFiM180";
    private static final String base64NetworkName = "bGFiTmV0d29yaw==";

    //Constructor
    public Token(){
        this.wifiProviderName = WifiEnabledVehicle.DEFAULT_WIFI_PROVIDER;
        this.wifiNetworkName = WifiEnabledVehicle.DEFAULT_WIFI_NAME;
    }


    //Major Methods
    public void validate() throws TokenValidatorException {
        if(this.wifiProviderName.isBlank() ||
                this.wifiProviderName.isEmpty()){
            throw new TokenValidatorException("No Wifi Provider provided.");
        }
        if (this.wifiNetworkName.isEmpty() ||
                this.wifiNetworkName.isBlank()){
            throw new TokenValidatorException("No Wifi Network Name Provided.");
        }
        if(this.wifiPassword.isEmpty() ||
                this.wifiPassword.isBlank()){
            throw new TokenValidatorException("No Password Entered!");
        }
        WifiProviderName providerName =
                WifiProviderNamesFactory.getWifiProvider(this.wifiProviderName);

        switch (providerName){
            case FORD_VEHICLE_WIFI_PROVIDER:
            case TOYOTA_VEHICLE_WIFI_PROVIDER:{
                checkNetworkName();
                checkPassword();
                break;
            }
            case NULL:{
                throw new TokenValidatorException("WRONG WIFI PROVIDER!");
            }
        }

    }

    public void generateTokenString() {
        this.tokenString = this.hashCode() + ":";
    }

    //Minor Methods
    private void checkNetworkName() throws TokenValidatorException {
        byte[] base64 = Base64.getEncoder().encode(this.wifiPassword.getBytes());
        String base64String = base64.toString();
        if(base64String != null
                && !base64String.isEmpty()
                && !base64String.isBlank()
                && !base64String.equals(this.base64NetworkName)){
            throw new TokenValidatorException("Wrong Network!");
        }

    }

    private void checkPassword() throws TokenValidatorException {
        byte[] base64 = Base64.getEncoder().encode(this.wifiPassword.getBytes());
        String base64String = base64.toString();
        if(base64String != null
                && !base64String.isEmpty()
                && !base64String.isBlank()
                && !base64String.equals(this.base64Password)){
            throw new TokenValidatorException("Wrong Password!");
        }
    }


    //Getters and Setters
    public void setWifiProviderName(String wifiProviderName) {
        this.wifiProviderName = wifiProviderName;
    }

    public void setWifiNetworkName(String wifiNetworkName) {
        this.wifiNetworkName = wifiNetworkName;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getWifiProviderName() {
        return wifiProviderName;
    }

    public String getWifiNetworkName() {
        return wifiNetworkName;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public String getTokenString() {
        return tokenString;
    }
}
