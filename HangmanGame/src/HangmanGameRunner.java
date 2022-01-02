import java.io.IOException;
import java.util.*;

/**
 *  The main client or runner for the Hangman game which runs the game:
 *  1. creates the Hangman object, initializes the states and images array, title, and phrase list
 *  2. chooses a random string from a dictionary of phrases that are loaded into the member variable of Hangman
 *  object created in step above
 *  3. initializes the missed and guessed counts
 *  4. prints welcome messages and rules of the game
 *  5. uses a while loop to check if the user has won already or has lost by exceeding the max number of misses
 *  6. inside the while loop: repeats the following steps 6a-6e:
 *  6a. prompts the user for a letter to guess and validates until user enters a valid English letter
 *  6b. checks whether the letter exists in the phrase
 *  6c. if letter exists updates the string and prints freindly messages to player about how many left, # of misses etc.
 *  6d. if all letters have been guessed correctly, user has won, and print message and exit out of the loop.
 *  6e. if letter not found, show hangman picture and number of misses and what has been completed and how many letters remain
 *  7. once the while loop is exited, check if user has lost and print the appropriate message
 */
public class HangmanGameRunner {


    /** Generic method to convert a char array to string
     * @param charArr : array of character primitives
     * @return String which is built from array of characters
     */
    public static String convertCharArrayToString(char[] charArr){
        String temp_str = "";
        // loop though char array and add each one to sring using string concatenation
        for (char c : charArr)
                temp_str += c;
        return temp_str;
    }

    public static void main(String[] args) throws IOException {
        //Start by creating the new game object which initializing all images and phrase bank
        HangmanGame hg = new HangmanGame();
        String[] art = new String[hg.MAX_MISS +1];
        String[] phrases = new String[hg.PHRASE_COUNT];
        // get all artwork strings for each  state into the art array
        art = hg.getGameArt();
        // get list of all possible phrases from HangmanGame object created into phrases
        phrases = hg.getPhraseBank();
//        for(int i = 0; i < hg.MAX_TRIES +1; i++){
//            System.out.println("Image" + i);
//            System.out.println(art[i]);;
//        }
//        for(int i = 0; i < hg.PHRASE_COUNT; i++){
//            System.out.println("Phrase" + i);
//            System.out.println(phrases[i]);;
//        }
        /*
            Begin game by selecting a phrase at random and showing the initial state
         */
        Random r=new Random();
        int randomNumber=r.nextInt(phrases.length);
        String phrase_chosen = phrases[randomNumber];
        //System.out.println(phrases[randomNumber]);

        // Display the phrase with all the letters to be guessed masked with '*' and all other punctuation intact
        String current_phrase = hg.displayInitialState(phrase_chosen);
        // The maximum number of guesses is the phrase length + max misses allowed +1
        int max_guess_tries = phrase_chosen.length()+hg.MAX_MISS +1;
        // Initialize the list of letters guessed so far - used for checking if user has already guessed the letter
        char[] guess_list_so_far = new char[max_guess_tries];
        // print title graphic and game instructions
        System.out.println(hg.getTitleArt());
        System.out.println("============================================================================================");
        System.out.println("I will randomly think of a phrase and you will have to guess what it is, step by step, one");
        System.out.println("letter at a time. At each step, if you guess a letter correctly, I will show you all the ");
        System.out.println("places where the letter occurs and each letter to be guessed will be shown with a '*'. ");
        System.out.println("At each step you will have to guess a single letter by typing a single letter when prompted.");
        System.out.println("Only lower and upper case letters in English are allowed for guesses. If your guess is ");
        System.out.println("correct, I will show you all the places where the letter occurs in the phrase.");
        System.out.println("Each incorrect guess counts as a miss and you are allowed upto 8 missed guesses before the ");
        System.out.println("game ends. At each miss I will show you the hangan picture that shows the number of misses");
        System.out.println("At each step I will show you how many letter are guessed correctly and how many remain");
        System.out.println("masked or to be guessed. The game ends when you win by guessing all the letters in my phrase");
        System.out.println("before you exhaust your 8 allowed misses or or you lose because you have exhausted your 8 ");
        System.out.println("allowed misses or incorrect guesses. Good Luck!");
        System.out.println("============================================================================================");
        System.out.println("Lets start the game with this phrase: " + current_phrase);

        //Initialize the # of misses and the # of guesses to zero
        int miss_count = 0;
        int guess_count = 0;
        // set flag for whether game is won
        boolean won_game = false;
        //As long as the number of misses is < 8 and the player has not won the game by correctly guessing all letters
        while((miss_count < hg.MAX_MISS) && !won_game)  {
            // Prompt the user to enter a letter guess
            System.out.println("Guess a letter (can be upper or lower case): ");
            Scanner scan_letter = new Scanner(System.in);
            char guess;
            boolean invalid_guess = false;
            // Keep prompting player for a guess until player enters a valid uppercase or lowercase letter
            do {
                String guess_string =  scan_letter.next();
                guess = guess_string.charAt(0);
                // Invalid guess can be a string with more than 1 letter or a letter that is not a upper or lower case English letter
                invalid_guess = (guess_string.length() != 1) || (!((guess >= 'A' && guess <= 'Z') || (guess >= 'a' && guess <= 'z'))) ;
                if(invalid_guess) {
                    System.out.println("Please re-enter a single valid letter in the alphabet (A-Z or a-z) : ");
                    invalid_guess = true;
                }
            } while (invalid_guess);

            //When the user enters their first guess or they re-enter the same letter from a prior guess don't penalize their choice
            if ((guess_count == 0) || (convertCharArrayToString(guess_list_so_far).indexOf(Character.toLowerCase(guess)) == -1)) {
//                if(guess_count != 0){
//                    System.out.println("Guesss list so far: " + convertCharArrayToString(guess_list_so_far));
//                }
                guess_list_so_far[guess_count] = Character.toLowerCase(guess);
                guess_count++;
                // if the letter guessed is in the phrase chosen by computer, update the state of the game and print messages
                if (hg.checkLetter(guess, phrase_chosen)) {
                    System.out.println("Great guessing, the letter " + guess + " is there in the phrase!");
                    // Update the state of the game if the letter is found (i.e. correctly guessed)
                    current_phrase = hg.updateStateifFound(current_phrase, guess, phrase_chosen);
                    // check if user has guessed all letters correctly, then print results and exit the while loop
                    if(hg.phraseComplete(current_phrase)){
                        System.out.println("Here is the complete phrase : " + current_phrase);
                        System.out.println("You have guessed all letters in the phrase and you still have " + (hg.MAX_MISS - miss_count) + " misses left!" );
                        System.out.println("Congratulations you've guessed the phrase correctly! You have won!");
                        System.out.println("========================================================================================");
                        won_game = true;
                        break;
                    }
                // If the letter the player guessed is not present, print message and show hangman picture corresponding to number of misses
                } else {
                    miss_count++;
                    System.out.println("Sorry the letter " + guess + " is not there in the phrase!");
                    System.out.println(art[miss_count]);

                }
                //At each step, print progress on how many letters are guessed correctly, how many misses and letter remain to be guessed
                int remaining = hg.lettersRemaining(current_phrase);
                int complete = hg.lettersCorrectlyGuessed(current_phrase);
                System.out.println("Progress: " + miss_count + " / " + hg.MAX_MISS + " misses allowed after " + guess_count + " letters guessed so far!");
                System.out.println("You still have " + (hg.MAX_MISS - miss_count) + " misses left!" );
                System.out.println("You have guessed " + complete + " letters, only " + remaining + " remaining to guess!");
                System.out.println("Here is what your current phrase looks like : " + current_phrase);

            }
            // if this letter is same as one already guessed, show message and don't penalize user
            else{
                System.out.println("You have already guessed the letter " + guess + ", try again!");
            }
            System.out.println("========================================================================================");
        }
        //If we exit out of the while loop and have exceeded the max number of misses, show messages that user has lost the game
        if(miss_count >= hg.MAX_MISS){
            System.out.println("Sorry you have exceeded the maximum number of misses allowed, You have lost this game");
            System.out.println("========================================================================================");
        }
    }
}
