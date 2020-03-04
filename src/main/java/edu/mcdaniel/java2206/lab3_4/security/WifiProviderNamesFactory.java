package edu.mcdaniel.java2206.lab3_4.security;

public class WifiProviderNamesFactory {

    public static WifiProviderName getWifiProvider(String input) {
        switch (input) {
            case "TOYOTA_VEHICLE_WIFI_PROVIDER":{
                return WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER;
            }
            case "FORD_VEHICLE_WIFI_PROVIDER": {
                return WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER;
            }
            default: {
                return WifiProviderName.NULL;
            }
        }
    }
}
