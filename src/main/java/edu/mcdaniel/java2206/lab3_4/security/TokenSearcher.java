package edu.mcdaniel.java2206.lab3_4.security;

public class TokenSearcher {

    //Assets
    // A array of tokens which are generated and handed to this class.
    private Token[] referenceTokens;

    // A token that is supposed to be found.
    private Token correctToken;


    // Constructors
    public TokenSearcher() {
        super();
        // Blank because we don't have any input.
    }

    public TokenSearcher(Token token) {
        this();
        this.correctToken = token;  // Since we were given the correct token.
    }

    public TokenSearcher(Token[] tokens) {
        this();
        this.referenceTokens = tokens; // Since we were given the reference tokens.
    }

    public TokenSearcher(Token token, Token[] tokens) {
        this.correctToken = token;
        this.referenceTokens = tokens;
    }


    //Major Methods
    public Token find(Token[] tokens, Token token) {
        this.referenceTokens = tokens;
        this.correctToken = token;

        return find();
    }


    //SEARCHING METHOD if reference Tokens are set up!
    public Token find(Token token) {
        this.correctToken = token;
        return find();
    }

    //Searching method if all things set up...
    public Token find() {
        //For each loop
        for (Token token : referenceTokens) {
            if (token.equals(this.correctToken)) {
                return correctToken;
            }
        }
        //RETURN NULL IF NOT FOUND!
        return null;
    }

    //WE assume that all things are set up.
    public int findPos() {
        //For Next
        for (int i = 0; i < referenceTokens.length; i++) {
            Token token = referenceTokens[i];
            if (token.equals(this.correctToken)) {
                return i;
            }
        }
        // If we fail to find, we will return -1
        return -1;
    }


}