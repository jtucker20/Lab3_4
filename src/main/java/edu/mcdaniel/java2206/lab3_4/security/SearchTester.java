package edu.mcdaniel.java2206.lab3_4.security;
import edu.mcdaniel.java2206.lab3_4.Application;

import java.util.logging.LogManager;

public class SearchTester {
    public static void main(String[] args) {
        Token[] tokens = new Token[10];
        Token correctToken = TokenFactory.getToken(WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(), "labNetwork", "password");

        for(int i = 0; i <10; i++){
            tokens[i] = TokenFactory.getToken(getWifiRando(i), "labNetwork", "password");
        }

        Token foundToken = TokenSearcher.find();
        foundToken.generateTokenString();
        int foundPos = TokenSearcher.findPos();

        String output = "Token {}, was found at position {}";
        LogManager.getLogManager(SearchTester.class).error(output, );

        }

    private static String getWifiRando(int i) {

    }
}

