package edu.mcdaniel.java2206.AndreBerry_lab3_4.security;

public class TokenSearcher
{
    //assets

    // an array of tokens made and given to the class
    private Token[] refrenceTokens;

    //token that is supposed to be found
    private Token correctToken;

    //Constructors
    public TokenSearcher(Token token)
    {
        this.correctToken = token;
    }

    public TokenSearcher(Token[] tokens)
    {
        this.refrenceTokens = tokens;
    }

    public TokenSearcher(Token token, Token[] tokens)
    {
        this(tokens);
        this.refrenceTokens = tokens;
    }


    //Major Methods
    public Token find(Token[] tokens, Token token)
    {
        this.refrenceTokens = tokens;
        this.correctToken = token;

        return find();
    }

    public Token find()
    {
        for(Token token : refrenceTokens)
        {
            if(token.equals(this.correctToken))
            {
                return correctToken;
            }
        }

        return null; //returns null if not found
    }
    //we assume that all things are set up.
    public int findPos() //for next
    {
        for(int i = 0; i < refrenceTokens.length; i++)
        {
            Token token = refrenceTokens[i];
            if(token.equals(this.correctToken))
            {
                return i;
            }
        }
        return -1; //if we fail to find, returns -1
    }

}
