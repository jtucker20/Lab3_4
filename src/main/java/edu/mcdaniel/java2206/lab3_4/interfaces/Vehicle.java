package edu.mcdaniel.java2206.lab3_4.interfaces;

public interface Vehicle {

    void accel(double percentOfMaxAccel);
    void brake(double percentOfMaxBrake);

    void turnOnLights();
    void toggleLights();

    String showLightsStatus();

    String showVehicleState();

}
