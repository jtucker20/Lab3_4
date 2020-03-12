package edu.mcdaniel.java2206.lab3_4.vehicles;

import edu.mcdaniel.java2206.lab3_4.car.VehicleAbstractClass;

public abstract class FordVehicle extends VehicleAbstractClass {
    private double speed;

    public FordVehicle(){
        super();
        setMake("Ford");
        speed = 0;
    }
    public String displaySpeedAsString(){
        return "This Toyota's speed is: " + speed;
    }

    public abstract String getWreckReportForFord();


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
