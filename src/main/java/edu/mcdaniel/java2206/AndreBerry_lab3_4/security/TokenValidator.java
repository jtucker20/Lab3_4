package edu.mcdaniel.java2206.AndreBerry_lab3_4.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TokenValidator {


    public static boolean validateToken(Token token){
        Token mirror = new Token();

        mirror.setWifiProviderName(token.getWifiProviderName());
        mirror.setWifiNetworkName(token.getWifiNetworkName());
        mirror.setWifiPassword(token.getWifiPassword());

        try{
            mirror.validate();
        } catch (TokenValidatorException tve){
            Logger logger = LogManager.getLogger(TokenValidator.class);
            logger.info(tve);
            return false;
        }

        mirror.generateTokenString();
        return mirror.getTokenString().equals(token.getTokenString());
    }
}
