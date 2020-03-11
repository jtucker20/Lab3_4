package edu.mcdaniel.java2206.lab3_4.security;

import javafx.application.Application;
import javafx.stage.Stage;

public class TokenSearcher {
    // An array of tokens to be generated
    private Token[] referenceTokens;

    // This is the token that is supposed to be found
    private Token correctToken;


    //constructors
    public TokenSearcher(){
        //empty because there is no input
    }

    public TokenSearcher(Token token){
        this();
        this.correctToken = token;
    }

    public TokenSearcher(Token[] tokens){
        this();
        this.referenceTokens = tokens;
    }

    public TokenSearcher(Token token, Token[] tokens){
        this.correctToken = token;
        this.referenceTokens = tokens;
    }

    //major methods
    public Token find(Token[] tokens, Token token){
        this.referenceTokens = tokens;
        this.correctToken = token;
        return find();
    }

    //searching method
    public Token find(Token token){
        this.correctToken = token;
        return find();
    }

    //searching method if all things set up
    public Token find(){
        // for each loop to search each token in the array
        for(Token token : referenceTokens){
            if(token.equals(this.correctToken)){
                return correctToken;
            }
        }
        //return null if not found
        return null;
    }
    //Assume that all tokens are already set up properly
    public int findPos(){
        for(int i = 0; i< referenceTokens.length; i++){
            Token token = referenceTokens[i];
            //this is searching each token to see if they are the correct token
            if(token.equals(this.correctToken)){
                return i;
            }
        }
        // if the correct token is not found, we return a -1
        return -1;
    }
    }

