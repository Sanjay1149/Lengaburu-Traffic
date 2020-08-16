package Vehicle;

import Orbit.Orbit;

public class Vehicle {
    int mmHr;
    int craterCross;
    String type;
    int timeTakenToCross;
    Orbit orbit;
    String orbitName;

    public Vehicle(int mmHr,int craterCross,Orbit orbitChosen,String orbitName, String type) {
        this.mmHr = mmHr;
        this.craterCross = craterCross;
        this.orbit = orbitChosen;
        this.orbitName = orbitName;
        this.type = type;
    }

    public int getTimeTakenToCross() {
        int timeTakenToCrossMm = ( 60 / Math.min( mmHr, orbit.getMaxSpeed() ) ) * orbit.getSpeedRequired();
        int timeTakenToCrossCrater = craterCross * orbit.getCraters();
        timeTakenToCross = timeTakenToCrossMm + timeTakenToCrossCrater;
        return timeTakenToCross;
    }

    public String getType() {
        return type;
    }

    public String getOrbitName() {
        return orbitName;
    }
}
