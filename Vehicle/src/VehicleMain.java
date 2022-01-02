import java.text.*;
/**
 * This program tests the Vehicle class and uses the Vehicle class to calculate and output quantities such as gallons to fill up tank fully and miles a
 * car can drive.
 * Client program to test the Vehicle data type.
 * 
 * @author Vishak Srikanth
 * @version 10/6/20
 */
public class VehicleMain
{
    public static void main(String[] args){
        //this segment test the Vehicle class and creates objects of the 
        //Vehicle class and tests the methords of the Vehicle class 
        //on the objects and outputs results.
        Vehicle jeep = new Vehicle(21,15.5);
        System.out.println(jeep);
        
        double fuel;
        fuel = jeep.fillItUp();
        System.out.println("You put " + fuel + " gallons of fuel into your "+
        "vehicle.");
        int mpg = jeep.getMilesPerGallon();
        System.out.println("Your vehicle gets " + mpg + " miles per gallon.");
        double tankSize = jeep.getTankSize();
        System.out.println("Your vehicle has a fuel tank capacity of " + 
        tankSize +  " gallons.");
        System.out.println("You have " + jeep.milesLeftOnTank() + 
        " miles left on your tank.");
        jeep.drive(100);
        System.out.println("You have " + jeep.milesLeftOnTank() + 
        " miles left on your tank.");
        jeep.drive(180);
        System.out.println("You have " + jeep.milesLeftOnTank() + 
        " miles left on your tank.");
        fuel = jeep.fillItUp();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println("You put " + df.format(fuel) + 
        " gallons of fuel into your vehicle.");
        System.out.println("You have " + jeep.milesLeftOnTank() + 
        " miles left on your tank.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println();
        Vehicle suv = new Vehicle (15, 19.8);
        System.out.println(suv); 
        
        fuel = suv.fillItUp();
        System.out.println("You put " + fuel + " gallons of fuel into your "+
        "vehicle.");
        mpg = suv.getMilesPerGallon();
        System.out.println("Your vehicle gets " + mpg + " miles per gallon.");
        tankSize = suv.getTankSize();
        System.out.println("Your vehicle has a fuel tank capacity of " + 
        tankSize +  " gallons.");
        System.out.println("You have " + suv.milesLeftOnTank() + 
        " miles left on your tank.");
        suv.drive(100);
        System.out.println("You have " + suv.milesLeftOnTank() + 
        " miles left on your tank.");
        suv.drive(180);
        System.out.println("You have " + suv.milesLeftOnTank() + 
        " miles left on your tank.");
        fuel = suv.fillItUp();
        System.out.println("You put " + df.format(fuel) + 
        " gallons of fuel into your vehicle.");
        System.out.println("You have " + suv.milesLeftOnTank() + 
        " miles left on your tank.");
        
      
        
      
       
        
    }
    
}
