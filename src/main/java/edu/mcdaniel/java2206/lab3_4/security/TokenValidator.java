package edu.mcdaniel.java2206.lab3_4.security;

public class TokenValidator {


    public static boolean validateToken(Token token){

        Token mirror = new Token();
        mirror.setWifiProviderName(token.getWifiProviderName());
        mirror.setWifiNetworkName(token.getWifiNetworkName());
        mirror.setWifiPassword(token.getWifiPassword());

        try{
            mirror.validate();
        } catch (TokenValidatorException tve){
            return false;
        }

        mirror.generateTokenString();

        return mirror.getTokenString().equals(token.getTokenString());
    }
}
