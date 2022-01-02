
/**
 * In this class, we will create accessor and mutator method for vehicle and calculate quantities such as gallons to fill up till
 * full tank and miles a vehicle can still drive to be used by VehicleMain.
 * 
 * Instructions:
 * The Vehicle class will be used to check the amount of fuel left in a
 * vehicle after traveling a certain distance. The class should have the 
 * instance variable <code> tankSize </code> to store the initial size of the 
 * tank and the instance variable <code> mpg </code> to store the initial 
 * miles per gallon of the vehicle.  Set to zero the instance variable <code> 
 * fuelInTank </code> that is used to store the initial amount of fuel in a 
 * tank. Complete implementations of all the methods are given below.
 *
 * @author Vishak Srikanth
 * @version 10/6/20
 */
public class Vehicle
{
    private double tankSize;
    private int mpg;
    private double fuelInTank; 
   
    

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(int mpg, double tankSize)
    {
        //set mpg and tankSize to arguments of this constructor
        this.mpg = mpg;
        this.tankSize = tankSize;
        //set fuel in tank to 0
        fuelInTank = 0;
        
    }
    
    /**
     * Returns the miles that this vehicle can drive based on how much fuel 
     * is left in the tank and the mpg.
     */
    public int milesLeftOnTank(){
        //miles left is the floor of mpg times fuel in tank
        int miles_left = (int) (mpg * fuelInTank);
        //return miles
        return miles_left;
    }
    
    /**
     * Mutator method that reduces the amount of fuel in tank based
     * on the number of miles driven and the mpg. 
     * 
     * @param miles the number of miles to drive
     */
    public void drive(int miles){
        //subtract gas used (miles/mpg) from previous fuel in tank
        fuelInTank-=((double) miles)/ ((double) mpg);
    }
    
    /**
     * A mutator method that fills up the tank and
     * also returns the number of gallons it took to fill it up. 
     */
    public double fillItUp(){
        //gallons to fill up is total maximum gas in tank minus fuel already in tank
        double  gallons_to_fill_up = tankSize - fuelInTank;
        //make fuel in tank tank maximum
        fuelInTank = tankSize;
        //return gallons added to reach a full tank
        return gallons_to_fill_up;
    }
    
    /**
     * Accessor method that returns the mpg of this vehicle.
     */
    public int getMilesPerGallon(){
        return mpg;
    }
    
    /**
     * Accessor method that returns the tank size (in gallons) of this vehicle.
     */
    public double getTankSize(){
        return tankSize;
    }
    
    /**
     * Returns a String representation of this vehicle in the following format:
     * "Miles per Gallon: mpg
     *  Fuel Tank Capacity: tank size
     *  "
     */
    @Override
    public String toString(){
        String output = "Miles per Gallon: " + mpg + "\nFuel Tank Capacity: " + tankSize + "\n";
        return output; 
    }    
}
