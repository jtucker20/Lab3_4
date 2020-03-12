package edu.mcdaniel.java2206.lab3_4.interfaces;

public interface VehicleWithMapping extends Vehicle{
    void setLocation(double x, double y);
    void setDestination(double x, double y);
    enum pitStops{
        RESTAURANT, GAS_STATION, DRUGSTORE;
    }
    String findNearby(VehicleWithMapping.pitStops pitStop);
    String getETA();
}
