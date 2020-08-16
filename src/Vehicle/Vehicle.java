package Vehicle;

import Orbit.Orbit;

public class Vehicle {
    int mmHr;
    int craterCross;
    String type;
    float timeTakenToCross;
    Orbit orbit;
    String orbitName;

    public Vehicle(int mmHr,int craterCross,Orbit orbitChosen,String orbitName, String type) {
        this.mmHr = mmHr;
        this.craterCross = craterCross;
        this.orbit = orbitChosen;
        this.orbitName = orbitName;
        this.type = type;
    }

    public float getTimeTakenToCross() {
        float timeTakenToCrossMm = ( (float) 60 / Math.min( mmHr, orbit.getMaxSpeed() ) ) * orbit.getSpeedRequired();
        float timeTakenToCrossCrater = craterCross * orbit.getCraters();
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
