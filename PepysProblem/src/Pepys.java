
/**
 * instructions
 * Which is more likely: at least one 6 in 6 rolls of a fair die,
 * or at least two 6's in 12 rolls of a fair die?
 * 
 * This class has methods that use simulations to approximate the
 * probability of rolling at least 1 six in 6 rolls and a methord to 
 * approximate the probability of rolling 2 sixes in 12 rolls.
 * @author Vishak Srikanth
 * @version 9/22/20
 */
import java.math.*;
public class Pepys
{
    /**  
     * @param n the number of simulations (experiments) to run
     * (A simulation is rolling a die 6 times.)
     * @return the estimated likelihood of rolling at least one 6 in 6 
     * rolls of a fair die 
     */
    public double probAtLeastOneSix(int n){
        //start by saying no trials have sixes rolled
        int number_of_trials_with_at_least_one_six =0;
        //repeat process for trials n times
        for(int i=1;i<=n;i++) {
            // initially set number of sixes in a trial to 0
            int six_count_for_one_in_six_being_sixes=0;
            for(int j=1;j<=6;j++) {
               //conduct roll by using the random methord to construct
               //a random integer greater than or equal to 1 and less than
               //7
               //take the floor of this integer to pick a random integer
               //between 1 and 6
              double roll_prelim = (6*Math.random() + 1);
              int roll = (int) roll_prelim;
              //if the roll is 6 increase count of sixes so far
              if(roll==6) {
                  six_count_for_one_in_six_being_sixes++;
                }
        
        }
        if(six_count_for_one_in_six_being_sixes >= 1) {
            //if there is more than 1 six in the trial add that trial
            //to the number of simulations with more than 1 six with six
            //rolls
              number_of_trials_with_at_least_one_six++;
            }
    }
       //find probability of more than 1 six in 6 rolls by dividing number of
       //trials with more than 1 six in 6 rolls by n
       double probability_in_simulations_for_one_six_in_six_rolls = (((double
       )(number_of_trials_with_at_least_one_six)/((n))));
        return probability_in_simulations_for_one_six_in_six_rolls; 
    }
    
     /**
     * @param n the number of simulations (experiments) to run
     * (A simulation is rolling a die 12 times.)
     * @return the estimated likelihood of rolling at least two 
     * 6's in 12 rolls of a fair die
     */
    public double probAtLeastTwoSixes(int n){
        //start by saying no trials have sixes rolled
        int number_of_trials_with_at_least_two_sixes =0;
        //repeat process for trials n times
        for(int i=1;i<=n;i++) {
            // initially set number of sixes in a trial to 0
            int six_count_for_two_in_twelve_being_sixes=0;
            for(int j=1;j<=12;j++) {
               //conduct roll by using the random methord to construct
               //a random integer greater than or equal to 1 and less than
               //7
               //take the floor of this integer to pick a random integer
               //between 1 and 6
              double roll_prelim = (6*Math.random() + 1);
              int roll = (int) roll_prelim;
              if(roll==6) {
                  //if the roll is 6 increase count of sixes so far
                  six_count_for_two_in_twelve_being_sixes++;
                }
        
        }
        if(six_count_for_two_in_twelve_being_sixes >= 2) {
              //if there is more than 2 sixes in the trial add that trial
            //to the number of simulations with more than 2 sixes with 
            //twelve rolls
              number_of_trials_with_at_least_two_sixes++;
            }
    }
    //find probability of more than 2 sixes in 12 rolls by dividing number of
    //trials with more than 2 sixes in 12 rolls by n
        double probability_in_simulations_for_two_sixes_in_twelve_rolls = ((
        (double)(number_of_trials_with_at_least_two_sixes)/((n))));
        return probability_in_simulations_for_two_sixes_in_twelve_rolls;
        
    }
 
}