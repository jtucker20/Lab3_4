package edu.mcdaniel.java2206.lab3_4.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;

import static org.junit.jupiter.api.Assertions.*;

class TokenSearcherTest {

    private Token correctToken;

    @BeforeEach
    void setUp() {
        this.correctToken = TokenFactory.getToken(
                WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password"
        );
        this.correctToken.generateTokenString();

    }

    @Test
    void doesCorrectTokenEqualItself(){

        // Arrange
        Token token = TokenFactory.getToken(
                WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password"
        );

        //Act
        token.generateTokenString();

        //Assert
        assertTrue(token.equals(this.correctToken));
    }

    @Test
    void trueinArray() {
        //Arrange
        Token token = TokenFactory.getToken(
                WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password"
        );
        Token token2 = TokenFactory.getToken(
                WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password"
        );
        Token[] tokens = new Token[2];
        tokens[0] = token;
        tokens[1] = token2;

        //Act
        tokens[0].generateTokenString();
        tokens[1].generateTokenString();


        //Assert
        assertTrue(this.correctToken.equals(tokens[0]));

    }

    @Test
    void find() {
        //Arrange
        Token token = TokenFactory.getToken(
                WifiProviderName.FORD_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password"
        );
        Token token2 = TokenFactory.getToken(
                WifiProviderName.TOYOTA_VEHICLE_WIFI_PROVIDER.toString(),
                "labNetwork", "password"
        );
        Token[] tokens = new Token[2];
        tokens[0] = token;
        tokens[1] = token2;



        //Act
        tokens[0].generateTokenString();
        tokens[1].generateTokenString();
        TokenSearcher searcher = new TokenSearcher(this.correctToken, tokens);
        Token found = searcher.find();


        //Assert
        assertTrue(this.correctToken.equals(found));

    }

    @Test
    void findPos() {
    }
}