
import java.io.*;
import java.util.*;

public class BoxOfProduceMain {
    public static void main(String[] args) {
        //give location of file
        File file = new File("inputs/randominputs.txt");
        //create an empty array to put the 5 fruits in
        String[] list_of_possible_fruits = new String[5];
        //no lines have been read so far
        int totalLines = 0;
        try
        {
            //scan file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                //add one to number of lines
                totalLines ++;
                //put next line into the array
                String line = scanner.nextLine();
                list_of_possible_fruits[totalLines-1]=line;
            }

            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        //create an object of class BoxOfProduce named box1
        BoxOfProduce box1 = new BoxOfProduce();
        //run the method in which the computer chooses random fruits from the five fruits imputed
        String [] box_chosen_by_computer = box1.select_random_fruits(list_of_possible_fruits);
        //set the contents of the Box of produce to the fruits chosen by the computer
        box1.setProduce_Number_1(box_chosen_by_computer[0]);
        box1.setProduce_Number_2(box_chosen_by_computer[1]);
        box1.setProduce_Number_3(box_chosen_by_computer[2]);
        //output the contents of the box of produce
        System.out.println("Creating initial box with random selection of fruits and vegetables...");
        System.out.println(box1.toString());
        //create objects and variables to be used in the while loop
        boolean user_wants_more_substitutions = true;
        Scanner user_input = new Scanner(System.in);
        boolean understood_last_answer=true;
        String item_to_replace_with;
        //check if user wants to make substitutions
        while(user_wants_more_substitutions==true) {
            if(understood_last_answer==true) {
                System.out.println("Would you like to substitute a produce in your text file for one in your current Box " +
                        "Of Produce? (Enter Yes or No) ");
            }
            String user_answer = user_input.next();
            if(user_answer.equalsIgnoreCase("no")==true){
                 //if user does not want more substitutions skip to printing final box by setting
                 // user_wants_more_substitutions to false
                 user_wants_more_substitutions=false;
            }
            else if(user_answer.equalsIgnoreCase("yes")==true){
                 understood_last_answer=true;
                //check which item the user wants to remove
                System.out.println("Enter which item you like to remove the first, second ,or third item in the box of produce " +
                        "currently? (Enter 1,2, or 3 only)");
                 int item_user_wants_to_be_removed = user_input.nextInt();
                 if(item_user_wants_to_be_removed<1 || item_user_wants_to_be_removed>3){
                     System.out.println("Error: There are three items in the box and you can only select one of the values 1, 2 ,or 3.");
                 }
                 else {
                     //find item user wants to replace removed item with
                     System.out. println("Which item would you like to replace the item which you removed with?");
                     //check whether replacement is in the text file
                     item_to_replace_with = user_input.next();
                     boolean item_to_replace_with_in_list_of_items_in_the_text_file = false;
                     for (int j=0;j<5;j++){
                         if(list_of_possible_fruits[j].equalsIgnoreCase(item_to_replace_with)==true) {
                             item_to_replace_with_in_list_of_items_in_the_text_file= true;
                         }
                     }
                     if(item_to_replace_with_in_list_of_items_in_the_text_file==false) {
                         //user cannot replace an item with produce not in the text file
                         System.out.println("You must replace the item which you removed with an item from the list of"+
                                 " items in your text file.");
                         System.out.println("You must enter one of the following bundles: " + Arrays.toString(list_of_possible_fruits));
                     }
                     if(item_to_replace_with_in_list_of_items_in_the_text_file==true) {
                         //If the item we want to replace an item in the bag with is in our text file, we set the produce
                         //in the bag to the item which we are replacing the item we removed with
                         if(item_user_wants_to_be_removed==1) {
                             box1.setProduce_Number_1(item_to_replace_with);
                         }
                         if(item_user_wants_to_be_removed==2) {
                             box1.setProduce_Number_2(item_to_replace_with);
                         }
                         if(item_user_wants_to_be_removed==3) {
                             box1.setProduce_Number_3(item_to_replace_with);
                         }
                         System.out.println(box1.toString());
                     }
                 }
            }
            else{
                //If we get an answer other than Yes or No, the computer will not understand the input and the user
                 // needs to enter the question again.
                understood_last_answer=false;
                 System.out.println("Invalid input: Please reenter your answer to the question: Would you like to substitute" +
                         " a produce in your text file for one in your current Box  Of Produce? (Enter Yes or No)");
             }
        }
//        System.out.println(box1.toString());
//        //test Box of Produce class and accessor, mutator, to string methods ,and constructors
//        BoxOfProduce box2 = new BoxOfProduce();
//        //set the produce in the bag
//        box2.setProduce_Number_1("Kiwi");
//        box2.setProduce_Number_2("Apple");
//        box2.setProduce_Number_3("Tomato");
//        //print each of the produce currently in the bag
//        System.out.println(box2.getProduce_Number_1());
//        System.out.println(box2.getProduce_Number_2());
//        System.out.println(box2.getProduce_Number_3());
//        //print out the produce in the bag in string format
//        System.out.println(box2.toString());
//        //try same exact methods and types of test after using the other constructor
//        BoxOfProduce box3 = new BoxOfProduce("Potato","Tomato","Apple");
//        //print each of the individual produce in the bag
//        System.out.println(box3.getProduce_Number_1());
//        System.out.println(box3.getProduce_Number_2());
//        System.out.println(box3.getProduce_Number_3());
//        //print out the produce in the bag in string format
//        System.out.println(box3.toString());
//        //set the produce in the bag
//        box3.setProduce_Number_1("Kiwi");
//        box3.setProduce_Number_2("Apple");
//        box3.setProduce_Number_3("Tomato");
//        //print each of the produce currently in the bag
//        System.out.println(box3.getProduce_Number_1());
//        System.out.println(box3.getProduce_Number_2());
//        System.out.println(box3.getProduce_Number_3());
//        //print out the produce in the bag in string format
//        System.out.println(box3.toString());
    }
}
