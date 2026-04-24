package lab_02_33;

public class FancyCar {

    // Declare private fields
    private final int FULL_TANK = 14;
    private String model;
    private int milesDriven;
    private double gasTank;
    private double MPG;
    private boolean engineOn;


    // Default constructor
    public FancyCar() {
        milesDriven = 5;
        gasTank = FULL_TANK;
        model = "Old Clunker";
        MPG = 24;
        engineOn = false;
    }

    // Constructor (String make, double mpg)
    public FancyCar(String make, double mpg) {
        this();
        model = make;
        MPG = mpg;
    }

    // Return car model
    public String getModel() {
        return model;
    }

    // Return miles per gallon (MPG)
    public double getMPG() {
        return MPG;
    }

    // Return miles on odometer
    public int checkOdometer() {
        return milesDriven;
    }

    // Return amount of gas in tank
    public double checkGasGauge() {
        return gasTank;
    }

    // Honk horn
    public void honkHorn() {
        System.out.println("The " + model + " says beep beep!");
    }

    // Drive car requested miles but check for enough
    // gas and check for positive value
    public void drive(int milesToDrive) {
        if (milesToDrive <= 0 || !engineOn) {
            return;
        }
        double gasNeeded = milesToDrive / MPG;
        if (gasNeeded < gasTank) {
            milesDriven += milesToDrive;
            gasTank -= gasNeeded;
        } else {
            int distance = (int) (gasTank * MPG);
            milesDriven += distance;
            gasTank = 0;
            engineOn = false;
        }
    }

    // Add gas to tank. Check for positive value.
    public void addGas(double amtToAdd) {
        if (amtToAdd <= 0 || engineOn) {
            return;
        }
        gasTank += amtToAdd;
        if (gasTank > FULL_TANK) {
            gasTank = FULL_TANK;
        }
    }

    // Set boolean variable to true
    public void startEngine() {
        engineOn = true;
    }

    // Set boolean variable to false
    public void stopEngine() {
        engineOn = false;
    }

}