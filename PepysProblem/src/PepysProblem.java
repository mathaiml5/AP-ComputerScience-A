
/**
 * This class PepysProblem runs the simulation methords in Pepys for the number
 * of simulations which the users enters that they want.
 * 
 * instructions:
 * Which is more likely: at least one 6 in 6 rolls of a fair die,
 * or at least two 6's in 12 rolls of a fair die?
 * 
 * Write a program that runs a simulation to estimate these probabilities.
 * 
 * from Wikipedia:
 * The Newton–Pepys problem is a probability problem concerning the 
 * probability of throwing sixes from a certain number of dice. In 1693 
 * Samuel Pepys and Isaac Newton corresponded over a problem posed by Pepys 
 * (pronunced "peeps") in relation to a wager he planned to make.The problem 
 * was: Which of the following three propositions has the greatest 
 * chance of success?
 * 
 * A. Six fair dice are tossed independently and at least one “6” appears.
 * B. Twelve fair dice are tossed independently and at least two “6”s appear.
 * C. Eighteen fair dice are tossed independently and at least three
 * “6”s appear.
 * 
 * Pepys initially thought that outcome C had the highest probability, but 
 * Newton correctly concluded that outcome A actually has the highest 
 * probability.
 *  
 * https://en.wikipedia.org/wiki/Newton%E2%80%93Pepys_problem
 * 
 * @author Vishak Srikanth 
 * @version 9/29/20
 * 
 * Sample run 1:
 * 
 *      Welcome to the Pepys Problem.
 *      Enter the number of simulations to run: 1000000
 *      The empirical probability of rolling at least one six if six dice are 
 *      rolled is: 0.664918
 *      The empirical probability of rolling at least two sixes if 12 dice are
 *      rolled is: 0.618532
 *      
 * Sample run 2:
 * 
 *      Welcome to the Pepys Problem.
 *      Enter the number of simulations to run: 10000
 *      The empirical probability of rolling at least one six if six dice are 
 *      rolled is: 0.6619
 *      The empirical probability of rolling at least two sixes if 12 dice are
 *      rolled is: 0.6209
 * 
 */

import java.util.Scanner;

public class PepysProblem
{
    public static void main(String[] args){
        //print out system dialog before user input
      System.out.println("Welcome to the Pepys Problem.");
      System.out.print("Enter the number of simulations to run: "); 
      Scanner simulation = new Scanner(System.in);
      int n =simulation.nextInt();
      System.out.print("The empirical probability of rolling at least "); 
      System.out.print("one six if six dice are rolled is: ");
      //creat an object that can use methords in class Pepys
      Pepys pepys = new Pepys();
      //use object and methords in class Pepys to get probabilities
      double one_six_in_six_roles_prob = pepys.probAtLeastOneSix(n);
      double two_sixes_in_twelve_roles_prob = pepys.probAtLeastTwoSixes(n);
      System.out.println(one_six_in_six_roles_prob);
      //print output
      System.out.print("The empirical probability of rolling at least "); 
      System.out.print("two sixes if 12 dice are rolled is: ");
      System.out.println(two_sixes_in_twelve_roles_prob);
    }
}