package edu.mcdaniel.java2206.lab3_4.security;


import org.apache.logging.log4j.LogManager;

public class SearchTester {

    public static void main(String[] args) {


        Token[] tokens = new Token[10];
        Token correctToken = TokenFactory.getToken(
                WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password");
        correctToken.generateTokenString();

        for(int i = 0; i < 10; i++){
            tokens[i] = TokenFactory.getToken(
                    getWifiRando(i),
                    "labNetwork", "password");
            tokens[i].generateTokenString();
        }

        TokenSearcher searcher = new TokenSearcher(correctToken, tokens);

        Token foundToken = searcher.find();
        foundToken.generateTokenString();
        int foundPos = searcher.findPos();


        String output = "Token {}, was found at position {}";
        LogManager.getLogger(SearchTester.class).error(output, foundToken.getTokenString(), foundPos);

    }


    public static String getWifiRando(int i){
        if(i % 9 == 2){
            return WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString();
        } else {
            return WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString();
        }
    }
}
