
/**
 * Pizza has private instance variables to store the size of a pizza, the number of cheese toppings, and the number
 * of pepperoni toppings, and the number of ham toppings. Pizza as constructors to set instance variables and
 * accessor and mutator methods for the instance variables, a method called calcCost() to determine the
 * cost of the pizza, and a method called getDescription() that prints a description of the pizza in string format.
 * Note: Since I wanted to experiment with casting from double to int, I chose to define all the number of
 * toppings variables as doubles!
 *
 * @author Vishak Srikanth
 * @version 10/13/20
 */
import java.math.*;
public class Pizza {
    //create instance variables for the number of each type of topping and 
    //the size of the pizza
    private String pizzaSize;
    // For some fun with conversions and casting of types I am defining these as doubles
    private double number_of_cheese_toppings;
    private double number_of_pepperoni_toppings;
    private double number_of_ham_toppings;
    //no getter and setter methods for cost since clients can't directly change cost instead they need to use calcCost
    //method
    private double cost;

    /**
     * getPizzaSize: getter method for pizza size
     * @param: none(getPizzaSize is a getter method with no inputs.)
     * @return: returns pizzaSize( a string)
     * */
     public String getPizzaSize() {

        return pizzaSize;
     }

    /**
     * Constructor for objects of class Pizza with toppings specified
     */
    public Pizza(String pizzaSize, double number_of_cheese_toppings,double number_of_pepperoni_toppings,
                 double number_of_ham_toppings)
    {
        //set pizza size, number_of_cheese_toppings , number_of_pepperoni_toppings ,and number_of_ham_toppings
        // to arguments of this constructor
        this.pizzaSize = pizzaSize;
        this.number_of_cheese_toppings = number_of_cheese_toppings;
        this.number_of_pepperoni_toppings = number_of_pepperoni_toppings;
        this.number_of_ham_toppings = number_of_ham_toppings;
    }

    /**
     * Constructor for objects of class Pizza if no arguments are passed in to the constructor
     */
    public Pizza()
    {
        //set pizza size to Small, number_of_cheese_toppings to 0, number_of_pepperoni_toppings to 0, and
        // number_of_ham_toppings to 0
        this.pizzaSize = "small";
        this.number_of_cheese_toppings = 0;
        this.number_of_pepperoni_toppings = 0;
        this.number_of_ham_toppings = 0;
    }



    /**
     * setPizzaSize: setter method for pizza size
     * @param pizzaSize (a string)
     * @return none(setPizzaSize is a void setter method.)
     */
    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    /**
     * getNumber_of_cheese_toppings: getter method for number of cheese toppings
     * @param:none(getNumber_of_cheese_toppings is a getter method with no inputs.)
     * @return:number_of_cheese_toppings(an double)
     */
    public double getNumber_of_cheese_toppings() {
        return number_of_cheese_toppings;
    }

    /**
     * setNumber_of_cheese_toppings: setter method for number of cheese toppings
     * @param: number_of_cheese_toppings (an double)
     * @return: none(setNumber_of_cheese_toppings is a void setter method.)
     */
    public void setNumber_of_cheese_toppings(double number_of_cheese_toppings) {
        this.number_of_cheese_toppings = number_of_cheese_toppings;
    }

    /**
     * getNumber_of_pepperoni_toppings: getter method for number of pepperoni toppings
     * @param:none(getNumber_of_pepperoni_toppings is a getter method with no inputs.)
     * @return:number_of_pepperoni_toppings(an double)
     */
    public double getNumber_of_pepperoni_toppings() {
        return number_of_pepperoni_toppings;
    }

    /**
     * setNumber_of_pepperoni_toppings: setter method for number of pepperoni toppings
     * @param: number_of_pepperoni_toppings (an double)
     * @return: none(setNumber_of_pepperoni_toppings is a void setter method.)
     */
    public void setNumber_of_pepperoni_toppings(double number_of_pepperoni_toppings) {
        this.number_of_pepperoni_toppings = number_of_pepperoni_toppings;
    }

    /**
     * getNumber_of_ham_toppings: getter method for number of ham toppings
     * @param:none(getNumber_of_ham_toppings is a getter method with no inputs.)
     * @return:number_of_ham_toppings(an double)
     */
    public double getNumber_of_ham_toppings() {
        return number_of_ham_toppings;
    }

    /**
     * setNumber_of_ham_toppings: setter method for number of ham toppings
     * @param: number_of_ham_toppings (an double)
     * @return: none(setNumber_of_ham_toppings is a void setter method.)
     */
    public void setNumber_of_ham_toppings(double number_of_ham_toppings) {
        this.number_of_ham_toppings = number_of_ham_toppings;
    }
    /**
     * calcCost: calculates and returns the cost of the pizza
     * @param: none
     * @return: cost( a double which is the cost of the pizza)
     */
    public double calcCost() {
        //calculate cost depending on pizza size by doing cost of pizza size + 2.00 * cheese toppings + 2.00 *
        // pepperoni toppings + 2 * ham toppings
        // A small pizza (the pizza itself) costs $10.00, a medium pizza costs $12.00 (the pizza itself), and
        // a large pizza (the pizza itself) costs $14.00.

        if(pizzaSize.equals("small")){
            //use formula for cost
            cost = 10.00 + number_of_cheese_toppings * 2.00 + number_of_pepperoni_toppings * 2.00
                    + number_of_ham_toppings * 2.00;
            return cost;
        }
        if(pizzaSize.equals("medium")){
            //use formula for cost
            cost = 12.00 + number_of_cheese_toppings * 2.00 + number_of_pepperoni_toppings * 2.00
                    + number_of_ham_toppings * 2.00;
            return cost;
        }
        if(pizzaSize.equals("large")){
            //use formula for cost
            cost = 14.00 + number_of_cheese_toppings * 2.00 + number_of_pepperoni_toppings * 2.00
                    + number_of_ham_toppings * 2.00;
            return cost;
        }
        else {
            System.out.println("Error: the only possible pizza sizes are Small, Medium, or Large.");
            return 0;
        }
    }
    /**
     * getDescription: returns a string which has the size of a pizza, 
     * the number of each type of topping the pizza has, and the cost of the
     * pizza - basically a "stringified" description of the pizza!
     * @param: none
     * @return: desription(a string which has  the size of a pizza, 
     * the number of each type of topping the pizza has, and the cost of the
     * pizza)
     */
    public String getDescription() {
        //write out the size of the pizza, the number of each type of topping, and the cost of the pizza into
        //a string and return the string.
        //typecast doubles as ints to remove decimal places( costs are always in full dollars for this program
        // so we are okay if we don't have decimal places after the number of dollars)
        String description = "The size of the pizza is " + pizzaSize + " and the pizza has " +
                (int) number_of_cheese_toppings + " cheese topping(s), " + (int) number_of_pepperoni_toppings +
                " pepperoni topping(s), and " + (int) number_of_ham_toppings +" ham topping(s) and the pizza costs $" +
                (int) cost + ".";
        return description;
    }


}
