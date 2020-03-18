package edu.mcdaniel.java2206.lab3_4.interfaces;

import edu.mcdaniel.java2206.lab3_4.security.Token;

public interface FlyingCar {

    //Wingspan of car (in inches)
    public double getWingspan();

    //Top speed of car while flying (mph)
    public int getFlightSpeed();

    //Company of cars jet engine
    public String getJetCompany();
}
