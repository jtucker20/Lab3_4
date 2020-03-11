package edu.mcdaniel.java2206.lab3_4.security;

import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

/**
 * This class IS NOT SECURE AND IS NOT TO BE TAKEN AS AN EXAMPLE OF HOW
 * TO PROGRAM SECURITY!!
 * THIS IS JUST A MOCK SO I CAN TEST YOUR IMPLEMENTATION.
 */
public class Token {

    //Private Assets
    private String wifiProviderName;
    private String wifiNetworkName;
    private String wifiPassword;
    private String tokenString;

    private static final String base64Password = "bGFiM180";
    private static final String base64DevelopmentPassword = "cGFzc3dvcmQ=";
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
        byte[] bytes1 = this.wifiProviderName.getBytes();
        byte[] bytes2 = this.wifiNetworkName.getBytes();
        byte[] bytes3 = this.wifiPassword.getBytes();
        int len = bytes1.length + bytes2.length + bytes3.length;
        byte[] bytes4 = new byte[len];
        System.arraycopy(bytes1, 0, bytes4, 0, bytes1.length);
        System.arraycopy(bytes2, 0, bytes4, bytes1.length, bytes2.length);
        System.arraycopy(bytes3, 0, bytes4, bytes1.length + bytes2.length, bytes3.length);
        byte[] base64 = Base64.getEncoder().encode(bytes4);
        this.tokenString = new String(base64);
    }

    //Minor Methods
    private void checkNetworkName() throws TokenValidatorException {
        byte[] base64Decoded = Base64.getDecoder().decode(base64NetworkName);
        byte[] bytes = this.wifiNetworkName.getBytes();
        boolean valid = Arrays.equals(base64Decoded, bytes);
        if(!valid){
            throw new TokenValidatorException("Wrong Network!");
        }

    }

    private void checkPassword() throws TokenValidatorException {
        byte[] base64Decoded = Base64.getDecoder().decode(base64Password);
        byte[] base64DevPwDcd = Base64.getDecoder().decode(base64DevelopmentPassword);
        byte[] bytes = this.wifiPassword.getBytes();
        boolean valid = Arrays.equals(base64Decoded, bytes);
        boolean devValid = Arrays.equals(base64DevPwDcd, bytes);
        if(!devValid && !valid){
            throw new TokenValidatorException("Wrong Password!");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime dueDate = LocalDateTime.of(2020, 3, 13, 23, 59);
        if (localDateTime.isAfter(dueDate)) {
            if(!valid){
                throw new TokenValidatorException("Wrong Password!");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;
        Token token = (Token) o;
        return getWifiProviderName().equals(token.getWifiProviderName()) &&
                getWifiNetworkName().equals(token.getWifiNetworkName()) &&
                getWifiPassword().equals(token.getWifiPassword()) &&
                Objects.equals(getTokenString(), token.getTokenString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWifiProviderName(), getWifiNetworkName(), getWifiPassword(), getTokenString());
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
