package edu.mcdaniel.java2206.lab3_4.car;

public abstract class VehicleAbstractClass {

    private String make;
    private String model;
    private String year;

    private boolean isOn;

    private int numberOfWrecks;

    public VehicleAbstractClass(){
        make = "";
        model = "";
        year = "2020";
        isOn = false;
        this.numberOfWrecks = 0;
    }

    public abstract String wreckReport();

    public int getNumberOfWrecks(){
        return this.numberOfWrecks;
    }

    public void setNumberOfWrecks(int numberOfWrecks) {
        this.numberOfWrecks = numberOfWrecks;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
