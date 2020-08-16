package Orbit;

public class Orbit {
    int mm;
    int craters;
    int maxSpeed;

    public Orbit(int mm, int craters,int maxSpeed) {
        this.mm = mm;
        this.craters = craters;
        this.maxSpeed = maxSpeed;
    }

    public int getCraters() {
        return craters;
    }

    public int getSpeedRequired() {
        return mm;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
