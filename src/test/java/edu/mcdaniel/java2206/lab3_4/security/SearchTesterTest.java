package edu.mcdaniel.java2206.lab3_4.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTesterTest {

    @Test
    void find() {
        //arrange
        Token token = TokenFactory.getToken(WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(),
                "labnetwork", "password");
        Token[] tokens = new Token[2];
        tokens[0] = token;
        Token token2 = null;
        tokens[1] = token2;


        //Act
        tokens[0].generateTokenString();
        tokens[1].generateTokenString();
        TokenSearcher searcher = new TokenSearcher()


    }

}