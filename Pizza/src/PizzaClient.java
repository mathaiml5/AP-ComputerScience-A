/**
 * This class contains client code for a client to use the Pizza class and tests the Pizza class.
 *
 * @author Vishak Srikanth
 * @version 10/13/20
 **/

import java.lang.*;
import java.io.*;

public class PizzaClient {
    public static void main(String[] args) {
        //test constructor for which the user enters the number of each topping and pizza size
        // we typecast doubles into ints to remove decimal places
        System.out.println("Creating Pizza 1 with full constructor: size = small, number_of_cheese_toppings= 1, number_of_pepperoni_toppings= 1, number_of_ham_toppings = 2");
        Pizza Pizza1 = new Pizza("small",1,1, 2);
        //
        //test getter methods
        System.out.println("Pizza 1 has size " +  Pizza1.getPizzaSize() + ".");
        System.out.println("Pizza 1 has " + (int) Pizza1.getNumber_of_cheese_toppings() + " cheese topping(s).");
        System.out.println("Pizza 1 has " + (int) Pizza1.getNumber_of_pepperoni_toppings() + " pepperoni topping(s).");
        System.out.println("Pizza 1 has " + (int) Pizza1.getNumber_of_ham_toppings() + " ham topping(s).");
        //test calcCost and get description methods
        System.out.println("Pizza 1 costs $" + (int)Pizza1.calcCost() + ".");
        System.out.println(Pizza1.getDescription());
        //test constructor with no arguments and getter methods
        System.out.println("Creating Pizza 2 with default (no argument) constructor which sets its size to small");
        Pizza Pizza2 = new Pizza();
        System.out.println("Pizza 2 initially has size " + Pizza2.getPizzaSize() + ".");
        System.out.println("Pizza 2 initially has " +(int)Pizza2.getNumber_of_cheese_toppings() +
                " cheese topping(s).");
        System.out.println("Pizza 2 initially has " + (int) Pizza2.getNumber_of_pepperoni_toppings() +
                " pepperoni topping(s).");
        System.out.println("Pizza 2 initially has " + (int) Pizza2.getNumber_of_ham_toppings() + " ham topping(s).");
        //test calcCost on initial entries for pizza 2 and get description methods
        System.out.println("Pizza 2 costs $" +(int)Pizza2.calcCost() + ".");
        System.out.println(Pizza2.getDescription());
        System.out.println("Testing setter methods: Changing Pizza 2's size to medium, number_of_cheese_toppings= 1, number_of_pepperoni_toppings= 2, number_of_ham_toppings = 3");
        Pizza2.setPizzaSize("medium");
        Pizza2.setNumber_of_cheese_toppings(1);
        Pizza2.setNumber_of_pepperoni_toppings(2);
        Pizza2.setNumber_of_ham_toppings(3);
        System.out.println("Pizza 2 now has size " + Pizza2.getPizzaSize() + ".");
        System.out.println("Pizza 2 now has " + (int) Pizza2.getNumber_of_cheese_toppings() + " cheese topping(s).");
        System.out.println("Pizza 2 now has " + (int) Pizza2.getNumber_of_pepperoni_toppings() +
                " pepperoni topping(s).");
        System.out.println("Pizza 2 now has " + (int) Pizza2.getNumber_of_ham_toppings() + " ham topping(s).");
        //test calcCost on initial entries and get description methods for pizza 2 after mutator methods are used
        System.out.println("Pizza 2 now costs $" +(int) Pizza2.calcCost() + ".");
        System.out.println(Pizza2.getDescription());
        //test constructor with pizza size and number of each type of topping and test mutator methods again
        Pizza Pizza3 = new Pizza("medium",0,2,
                5);
        System.out.println("Pizza 3 initially has size " + Pizza2.getPizzaSize() + ".");
        System.out.println("Pizza 3 initially has " + (int) Pizza3.getNumber_of_cheese_toppings() +
                " cheese topping(s).");
        System.out.println("Pizza 3 initially has " + (int) Pizza3.getNumber_of_pepperoni_toppings() +
                " pepperoni topping(s).");
        System.out.println("Pizza 3 initially has " + (int) Pizza3.getNumber_of_ham_toppings() + " ham topping(s).");
        //test calcCost on initial entries for pizza 3 and get description methods
        System.out.println("Pizza 3 costs $" +(int) Pizza3.calcCost() + ".");
        Pizza3.setPizzaSize("large");
        Pizza3.setNumber_of_cheese_toppings(1);
        Pizza3.setNumber_of_pepperoni_toppings(4);
        Pizza3.setNumber_of_ham_toppings(6);
        System.out.println("Pizza 3 now has size " + Pizza3.getPizzaSize() + ".");
        System.out.println("Pizza 3 now has " + (int)Pizza3.getNumber_of_cheese_toppings() + " cheese topping(s).");
        System.out.println("Pizza 3 now has " + (int)Pizza3.getNumber_of_pepperoni_toppings() +
                " pepperoni topping(s).");
        System.out.println("Pizza 3 now has " + (int)Pizza3.getNumber_of_ham_toppings() + " ham topping(s).");
        //test calcCost on initial entries and get description methods for pizza 3 after mutator methods are used
        System.out.println("Pizza 3 costs $" +(int)Pizza3.calcCost() + ".");
        System.out.println(Pizza3.getDescription());
    }
}
