import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The main HangmanGame class has functions to render state and update state of the game,
 * provide the output strings, load the title, ASCII images for each state and word bank text files
 */
public class HangmanGame {
    // Maximum misses is set to 8
    public static int MAX_MISS = 8;
    // This is how many phrases are in the list which can be used for game
    public static int PHRASE_COUNT = 10;
    // Initialize the string array for the game ASCII art for each miss level to show hangman picture
    private String[] game_art = new String[MAX_MISS +1];
    // Initialize the string array for the collection of phrases used
    private String[] phrase_bank = new String[PHRASE_COUNT];
    private String title_art = new String();
    //Set the file name for phrases to be used
    private static String PHRASE_FILE = "src/resources/phrases/phrases.txt";
    //Set the filename which contains title ascii art
    private static String TITLE_FILE = "src/resources/images/hangman_title.txt";


    /** Function used to read the text files into an array of Strings
     * @param filename - the file name which contains a list of strings with 1 string per line used for lis of phrases
     * @return Array of Strings from the file
     * @throws IOException
     */
    public String[] readLines(String filename) throws IOException {
        // Create a file readerstream based on input filename
        FileReader fileReader = new FileReader(filename);
        // Transform to buffered reader
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        // read input 1 line at a time and add to a list of strings
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        // Convert string list to string array and return
        return lines.toArray(new String[lines.size()]);
    }

    /** Function to display the initial state of the game where all letters to be guessed are replaced with '*'
     * @param current_string: input string with the phrase chosen by computer
     * @return String with all letters to be guessed replaced with '*" while all punctuation is left intact
     */
    public String displayInitialState(String current_string){
        String s = current_string;
        // Display an asterisk ('*') for each letter character only
        for (int i = 0; i < s.length(); i++)
        {

            // Finding the character whose ASCII value fall under the letter range
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
            {
                s = s.substring(0, i) + "*" + s.substring(i + 1);
            }
        }
        return s;
    }

    /** Function to check if all the letters have been guessed by the user
     * @param current_string : current state of the game with all letters guessed by user shown and rest with '*"
     * @return true if all letters have been guessed and false otherwise
     */
    public boolean phraseComplete(String current_string){
            int cnt = 0;
            // Count how many asterisks ('*') are left which indicates how many letters need to be guessed
            for (int i = 0; i < current_string.length(); i++)
            {
                if (current_string.charAt(i) == '*')
                {
                    // Count up # of times the character * appears
                    cnt++;
                }
            }
            // if the count of characters to be guessed is zero then phrase has been guessed completely by user
            return (cnt==0);
    }

    /** Function to check how many letters remain to be guessed by user
     * @param current_string: current state of the game with user's correctly guessed letters shown and rest with '*'
     * @return count of how many letters remain to be guessed
     */
    public int lettersRemaining(String current_string){
        int cnt = 0;
        // Count how many asterisks ('*') are left in phrase
        for (int i = 0; i < current_string.length(); i++)
        {
            if (current_string.charAt(i) == '*')
            {
                // Count up # of times the character * appears
                cnt++;

            }
        }
        // returns how many letters are still remaining to be guessed
        return cnt;
    }

    /** Function to count up how many letters in the phrase have already been guessed by user
     * @param current_string : current state of the game with user's correctly guessed letters shown and rest with '*'
     * @return count of how many letters have been guessed correctly by user
     */
    public int lettersCorrectlyGuessed(String current_string){
        int cnt = 0;
        String s = current_string;
        // Count how many letters have been guessed
        for (int i = 0; i < current_string.length(); i++)
        {
            char c = s.charAt(i);
            // only alphabetic characters both upper and lower case guessed correctly are counted
            if ((c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z'))
            {
                // Count up # of times the character * appears
                cnt++;

            }
        }
        // return the count of letters guessed correctly
        return cnt;
    }


    /** Function to check whether the guessed letter is in the orginal phrase chosen by computer
     * @param letter : the letter the user guessed in the current try
     * @param answer : the original phrase chosen by the computer to be guessed by the player
     * @return true if letter is present in the chosen phrase, false if not found
     */
    public boolean checkLetter(char letter, String answer) {
        boolean found = false;
        for (int i = 0; i < answer.length(); i++) {
            // See if the guessed letter is in the answer string in case insensitve manner
            if (Character.toLowerCase(answer.charAt(i)) == Character.toLowerCase(letter)) {
                found = true;
                break;
            }
        }
        return found;

    }

    /** This function takes the current player guessed letter, checks if the letter is found and updates the game state
     *  to show all the correctly guessed letters so far and replaces all remaining ones are left intact with '*'
     * @param current_string :  state of the game with user's correctly guessed letters shown and rest with '*',
     *                          prior to current guess
     * @param letter : current player's guess
     * @param answer : the origina phrase chosen by computer
     * @return string that shows the updated state of the game with user's correctly guessed letters shown and
     *         rest with '*', after the current player's guess letter is checked
     */
    public String updateStateifFound(String current_string, char letter, String answer){
        String s = current_string;
        for (int i = 0; i < s.length(); i++)
        {
            // Update only the found characters in the current string
            if (Character.toLowerCase(answer.charAt(i)) == Character.toLowerCase(letter))
            {


                s = s.substring(0, i) + answer.charAt(i) + s.substring(i + 1);

            }
        }
        return s;
    }

    /** default constructor for the Hangman object which initializes all images, title art and list of phrases
     * @throws IOException for file read write operations for loading ascii art images or phrase list
     */
    public HangmanGame() throws IOException {
        // There are max_miss+1 images (for each miss there is a different image and one for initial image)
        String[] temp = new String[this.MAX_MISS +1];
        // loop through all images files one at a time and load them into the String array
        for(int i = 0; i < this.MAX_MISS +1; i++){
            String file = "src/resources/images/hangman_image_" + "" + i + ".txt";
            temp[i] = new String(Files.readAllBytes(Paths.get(file)));
        }
        // Use the setter method to set the private variable that holds all the image art for each state
        setGameArt(temp);
        // load list of phrases into private variable
        String[] temp2 = new String[this.PHRASE_COUNT];
        temp2 = this.readLines(PHRASE_FILE);
        // Use the setter method to set the private variable that holds all the phrases that can be used
        setPhraseBank(temp2);
        // Use the setter method to set the private variable that holds title art
        setTitleArt(new String(Files.readAllBytes(Paths.get(TITLE_FILE))));

    }

    /** Gets all the game art images
     * @return string array of images
     */
    public String[] getGameArt() {
        return game_art;
    }

    /** Sets all the game art images from Sting array
     * @param game_art
     */
    public void setGameArt(String[] game_art) {
        this.game_art = game_art;
    }

    /** gets the list of phrases that game uses
     * @return
     */
    public String[] getPhraseBank() {
        return phrase_bank;
    }

    /** Sets all the phrases used in game from Sting array
     * @param phrase_bank
     */
    public void setPhraseBank(String[] phrase_bank) {
        this.phrase_bank = phrase_bank;
    }

    /** gets title art string
     * @return
     */
    public String getTitleArt() {
        return title_art;
    }

    /** Sets title art string
     * @param title_art
     */
    public void setTitleArt(String title_art) {
        this.title_art = title_art;
    }
}
