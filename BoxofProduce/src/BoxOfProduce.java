package src;

/**
 * We will create an class called Box of Produce which contains 3 items chosen randomly from a set input from text input file
 * We will create accessor and mutator methods for each produce in the box and
 * a toString() method that outputs the details of the produce items in the box of produce.
 * BoxOfProduce: contains 3 boxes of fruits and vegetables
 *
 * @author Vishak Srikanth
 * @version 10/14/20
 */
import java.lang.Math;
public class BoxOfProduce {
    //create instance variables for each produce in the box of produce
    private String produce_Number_1;
    private String produce_Number_2;
    private String produce_Number_3;
    /**
     * Constructor for objects of class BoxOfProduce when each produce in the box is passed into the constructor
     */
    public BoxOfProduce(String produce_Number_1,String produce_Number_2, String produce_Number_3)
    {
        //set produce_Number_1, produce_Number_2 ,and produce_Number_3 to the arguments of this constructor
        this.produce_Number_1 = produce_Number_1;
        this.produce_Number_2 = produce_Number_2;
        this.produce_Number_3 = produce_Number_3;
    }

    /** Default constructor
     *
     */

    public BoxOfProduce()
    {
        //set produce_Number_1, produce_Number_2 ,and produce_Number_3 to empty strings
        this.produce_Number_1 = "";
        this.produce_Number_2 = "";
        this.produce_Number_3 = "";
    }


    /**
     * getProduce_Number_1(): a setter method to set the first item in the box of produce
     * @param(none: this is a getter method with no arguments.)
     * @return produce_Number_1( the first item in the box of produce)
     */
    public String getProduce_Number_1() {
        return produce_Number_1;
    }

    /**
     * setProduce_Number_1:a setter method to set produce_Number_1: the first item in the box of produce
     * @param produce_Number_1(The String with the first item in the box of produce is set to.)
     * @return:none( This is a void setter method.)
     */
    public void setProduce_Number_1(String produce_Number_1) {
        this.produce_Number_1 = produce_Number_1;
    }

    /**
     * getProduce_Number_2(): a setter method to set the second item in the box of produce
     * @param(none: this is a getter method with no arguments.)
     * @return produce_Number_2( the second item in the box of produce)
     */
    public String getProduce_Number_2() {
        return produce_Number_2;
    }

    /**
     * setProduce_Number_2:a setter method to set produce_Number_2: the second item in the box of produce
     * @param produce_Number_2(The String with the second item in the box of produce is set to.)
     * @return:none( This is a void setter method.)
     */
    public void setProduce_Number_2(String produce_Number_2) {
        this.produce_Number_2 = produce_Number_2;
    }

    /**
     * setProduce_Number_3:a setter method to set produce_Number_3: the third item in the box of produce
     * @param(none: this is a getter method with no arguments.)
     * @return produce_Number_3( the third item in the box of produce)
     */
    public String getProduce_Number_3() {
        return produce_Number_3;
    }

    /**
     * getProduce_Number_3(): a setter method to set the third item in the box of produce
     * @param produce_Number_3(The String with the third item in the box of produce is set to.)
     * @return:none( This is a void setter method.)
     */
    public void setProduce_Number_3(String produce_Number_3) {
        this.produce_Number_3 = produce_Number_3;
    }
    /**
     * toString(): a method which gives the produce the box has in the format of a string
     * @param: none
     * @return: description: a string which has the produce in the box of produce
     */
    public String toString() {
        String description = "The box of produce contains 3 bundles of fruits and vegetables: Bundle1: " + produce_Number_1 +", Bundle2: " + produce_Number_2
                + " , and  Bundle3: " +produce_Number_3 + ".";
        return description;
    }

    /**
     * select_random_fruits: a method in which the computer chooses fruits from the string array passed to the method
     * @param possible_fruits (an array containing the fruits from which the box is to be chosen)
     * @return chosen_fruits_prelim( the box of fruits the computer chooses randomly)
     */
    public String [] select_random_fruits  (String [] possible_fruits) {
        //create an empty array to store the chosen fruits
        String [] chosen_fruits_prelim = new String[3];
       for(int i=0;i<=2;i++){
           //choose an integer n between 0 and 4 and make the nth entry in the text file the selected fruit
           int current_selected_fruit = (int)(5*Math.random());

             chosen_fruits_prelim[i]=possible_fruits[current_selected_fruit];
       }

       return chosen_fruits_prelim;
    }
}
