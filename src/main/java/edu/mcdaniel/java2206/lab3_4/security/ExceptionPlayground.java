package edu.mcdaniel.java2206.lab3_4.security;

public class ExceptionPlayground {
    public static void main(String[] args) {
        Token token = new Token();
        token.setWifiNetworkName("");
        token.setWifiProviderName("");
        token.setWifiPassword("");

        try{
            token.validate();
        } catch(TokenValidatorException tve){
            tve.printStackTrace();
        }
    }
}
