package edu.mcdaniel.java2206.lab3_4;

import edu.mcdaniel.java2206.lab3_4.fords.FordF150;
import edu.mcdaniel.java2206.lab3_4.fords.FordFocus;
import edu.mcdaniel.java2206.lab3_4.interfaces.Vehicle;
import edu.mcdaniel.java2206.lab3_4.interfaces.WifiEnabledVehicle;
import edu.mcdaniel.java2206.lab3_4.security.Token;
import edu.mcdaniel.java2206.lab3_4.security.TokenValidator;
import edu.mcdaniel.java2206.lab3_4.toyotas.ToyotaCamry;
import edu.mcdaniel.java2206.lab3_4.toyotas.ToyotaCorolla;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is designed to start/wrap your class.
 */
@SpringBootApplication
public class Application {

    //=============================================================================================
    // Private Assets
    //=============================================================================================

    /**
     * The logging mechanism of the class.
     */
    private static Logger log;


    //=============================================================================================
    // Constructor(s)
    //=============================================================================================

    /**
     * The constructor for the Spring Boot application
     */
    public Application(){
        //This constructor is empty as no additional information need be provided.
        //This is an implemented No Argument Constructor.
    }


    //=============================================================================================
    // Major Methods
    //=============================================================================================

    //No major methods to implement


    //=============================================================================================
    // PSVM
    //=============================================================================================

    /**
     * This method actually accomplishes the running of the code we are seeking to write
     * @param args the input from the command line.
     */
    public static void main(String[] args) throws Exception {

        //===// Spring Application Hook //=======================================================//
        SpringApplication.run(Application.class, args);
        log = LogManager.getLogger(Application.class);

        //===// Do not modify, please //=========================================================//
        ToyotaCamry veh1 = new ToyotaCamry();
        ToyotaCorolla veh2 = new ToyotaCorolla();
        //Here I'm making the Ford Vehicles
        FordFocus veh3 = new FordFocus();
        FordF150 veh4 = new FordF150();

        //Adding these to the list

        List<Vehicle> vehicleList = new ArrayList<>();
        List<WifiEnabledVehicle> wifiVehicles = new ArrayList<>();
        vehicleList.add(veh1);
        wifiVehicles.add(veh1);
        vehicleList.add(veh2);
//        wifiVehicles.add(veh2);
        vehicleList.add(veh3);
//        wifiVehicles.add(veh3);
        vehicleList.add(veh4);
//        wifiVehicles.add(veh4);

        for(Vehicle vehicle : vehicleList){

            if(vehicle instanceof ToyotaCorolla){
                ToyotaCorolla thisToyotaCorolla = (ToyotaCorolla) vehicle;
                thisToyotaCorolla.corollaLightsDim(0.0);
            }
        }


        for(Vehicle vehicle : vehicleList){
            vehicle.turnOnLights();
        }
        //For your convenience, I'm providing a dev password that will expire!!!
        //You only have until the due date before it stops working!
        String devPassword = "password";
        for(WifiEnabledVehicle vehicle : wifiVehicles){
            if(vehicle instanceof FordFocus){
                continue;
            }
            vehicle.setWifiPassword(devPassword);
            Token token = vehicle.getToken();
            log.info("This is your vehicle's wifi token: {}", token.getTokenString());
            boolean validated = TokenValidator.validateToken(token);

            if(!validated){
                throw new Exception("INVALID IMPELMENTATION!");
            }
        }

        for(Vehicle vehicle : vehicleList){
            log.debug(vehicle.showLightsStatus());
        }

        log.debug("Predefined behavior ends.");


        //Doing some actions on the vehicles.
        for(Vehicle vehicle : vehicleList){
            vehicle.accel(50);
            vehicle.toggleLights();
            vehicle.brake(75);
        }

        //Printing out the state
        for(Vehicle vehicle : vehicleList){
            log.debug(vehicle.showVehicleState());
        }
    }


    //=============================================================================================
    // Minor Methods(s)
    //=============================================================================================

    //No minor methods made for this class


    //=============================================================================================
    // Getters and Setters
    //=============================================================================================

    //No private assets we want to expose in this class

}
