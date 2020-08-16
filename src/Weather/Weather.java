package Weather;

import Vehicle.Vehicle;

public class Weather {
    int craterDiscount;
    String weather;
    String[] allowedVehicles;

    public Weather(String weather) {
        this.weather = weather;
    }

    public int getCraterDiscount() {
        if ( weather.equals("SUNNY") ) {
            craterDiscount = -10;
        } else if ( weather.equals("RAINY") ) {
            craterDiscount = 20;
        } else {
            craterDiscount = 0;
        }
        return craterDiscount;
    }

    public String[] getAllowedVehicles() {
        if ( weather.equals("SUNNY") ) {
            allowedVehicles = "BIKE TUKTUK CAR".split(" ");
        } else if ( weather.equals("RAINY") ) {
            allowedVehicles = "TUKTUK CAR".split(" ");
        } else {
            allowedVehicles = "BIKE CAR".split(" ");
        }
        return allowedVehicles;
    }
}
