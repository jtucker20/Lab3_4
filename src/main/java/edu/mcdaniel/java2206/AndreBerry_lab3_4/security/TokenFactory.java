package edu.mcdaniel.java2206.AndreBerry_lab3_4.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TokenFactory {

    public static Token getToken(String wifiProviderName, String wifiName, String wifiPassword){

        Logger log = LogManager.getLogger(TokenFactory.class);
        Token token = new Token();
        token.setWifiProviderName(wifiProviderName);
        token.setWifiNetworkName(wifiName);
        token.setWifiPassword(wifiPassword);

        try {
            token.validate();
        } catch (TokenValidatorException tve){
            log.error(tve);
            return null;
        }

        token.generateTokenString();

        return token;
    }
}
