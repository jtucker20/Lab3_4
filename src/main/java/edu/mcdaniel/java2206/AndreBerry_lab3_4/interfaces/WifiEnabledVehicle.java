package edu.mcdaniel.java2206.AndreBerry_lab3_4.interfaces;

import edu.mcdaniel.java2206.AndreBerry_lab3_4.security.Token;

public interface WifiEnabledVehicle {

    /**
     * Default Wifi Provider message
     */
    public static final String DEFAULT_WIFI_PROVIDER = "Default Wifi Provider";
    public static final String DEFAULT_WIFI_NAME = "Default Wifi Name";

    /**
     * Wifi provider name
     */
    public String getWifiProvider();

    /**
     * Wifi Network Name
     */
    public String getNetworkName();

    /**
     * Wifi token
     */
    public Token getToken();

    /**
     * Password setter
     */

    public void setWifiPassword(String password);

}
