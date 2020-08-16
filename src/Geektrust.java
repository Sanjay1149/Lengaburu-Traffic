import Orbit.Orbit;
import Vehicle.Vehicle;
import Weather.Weather;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Geektrust {
    public static Map<String, Map<String,Integer>> vehicleDetails = new HashMap<>();
    public static Vehicle bestVehicle;
    public static int timeTaken = Integer.MAX_VALUE;

    public static void initializeVehicleDetails() {
        Map<String,Integer> carDetails = new HashMap<>();
        carDetails.put("mmHr",20);
        carDetails.put("cross",3);
        vehicleDetails.put("CAR",carDetails);

        Map<String,Integer> bikeDetails = new HashMap<>();
        bikeDetails.put("mmHr",10);
        bikeDetails.put("cross",2);
        vehicleDetails.put("BIKE",bikeDetails);

        Map<String,Integer> autoDetails = new HashMap<>();
        autoDetails.put("mmHr",12);
        autoDetails.put("cross",1);
        vehicleDetails.put("TUKTUK",autoDetails);
    }

    public static void main(String[] args) {
        int timeTakenToCross;
        /**
         * Initializing the Vehicle Details
         */
        initializeVehicleDetails();
        try{
            /**
             *  Reading Input from the Input File
             */
            FileInputStream inputStream = new FileInputStream(new File("src/Computing/input.txt").getAbsolutePath());
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String[] input =  br.readLine().split(" ");
            inputStream.close();

            String weatherName = input[0];
            Weather weather = new Weather(weatherName);
            int craterDiscount = weather.getCraterDiscount();
            int orbitOneCrate = 20 + ( 20 * craterDiscount ) / 100;
            int orbitTwoCrate = 10 + ( 10 * craterDiscount ) / 100;

            /**
             *  Orbit Statistics Based On Given Weather & Traffic Situation
             */
            int orbitOneMaxSpeed = Integer.parseInt(input[1]);
            int orbitTwoMaxSpeed = Integer.parseInt(input[2]);
            Orbit orbit1 = new Orbit(18,orbitOneCrate,orbitOneMaxSpeed);
            Orbit orbit2 = new Orbit(20,orbitTwoCrate,orbitTwoMaxSpeed);


            /**
             *  Calculation for Time Taken by the Vehicle to cross each Orbits
             */
            String allowedVehicles[] = weather.getAllowedVehicles();
            for ( String vehicle : allowedVehicles ) {
                int vehicleMmHr = vehicleDetails.get(vehicle).get("mmHr");
                int vehicleCross = vehicleDetails.get(vehicle).get("cross");

                Vehicle vehicleOrbit1 = new Vehicle(vehicleMmHr,vehicleCross,orbit1,"ORBIT1",vehicle);
                timeTakenToCross = vehicleOrbit1.getTimeTakenToCross();
//                System.out.println(vehicleOrbit1.getType() + " takes " + timeTakenToCross);
                /**
                 *  Checking if Orbit1 for this vehicle is the Fastest Route to cross
                 */
                if ( timeTakenToCross < timeTaken ) {
                    bestVehicle = vehicleOrbit1;
                    timeTaken = timeTakenToCross;
                }

                Vehicle vehicleOrbit2 = new Vehicle(vehicleMmHr,vehicleCross,orbit2,"ORBIT2",vehicle);
                timeTakenToCross = vehicleOrbit2.getTimeTakenToCross();
//                System.out.println(vehicleOrbit2.getType() + " takes " + timeTakenToCross);
                /**
                 *  Checking if Orbit2 for this vehicle is the Fastest Route to cross
                 */
                if ( timeTakenToCross < timeTaken ) {
                    bestVehicle = vehicleOrbit2;
                    timeTaken = timeTakenToCross;
                }

            }
//            System.out.println("SOLUTION IS ");
//            System.out.println(bestVehicle.getType() + " " + bestVehicle.getOrbitName());

            /**
             *  Writing to the Output File
             */
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(new File("src/Computing/output.txt").getAbsolutePath()));
            fileOut.write(bestVehicle.getType() + " " + bestVehicle.getOrbitName());
            fileOut.close();

        }catch(Exception exception){
            System.out.println(exception);
        }
    }
}
