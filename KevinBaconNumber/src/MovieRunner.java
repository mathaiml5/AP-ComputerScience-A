import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class MovieRunner
{
    static boolean USE_SMALL_MOVIE_TEST_FILE = false;
    public static void main(String[] args)
    {
        String filename;
        //To test that the Kevin bacon number calculation is correct I created a small actor graph with 8 movies and 15 actors
        if(USE_SMALL_MOVIE_TEST_FILE){
            filename = new String("inputs/movie-test.txt");
        }
        else {
            filename = new String("inputs/movies-top-grossing.txt");
        }
        // read input file
        List<String> movieList = readFile(filename);
        MovieDatabase movieDatabase = new MovieDatabase();
        //for each line which has a single movie's data
        for(String movie: movieList){
            //Split the line on / which will give multiple tokens 1st is movie info and rest are actor names
            String[] partsOfStringMovie = movie.split("/");
            //Parse 1st entry which has movie ttile and year
            String[] movieTitleAndYear = partsOfStringMovie[0].split(" "+Pattern.quote("("));
            String movieTitle=movieTitleAndYear[0];
            int index=0;
            //Get the correct format of the title when it begins with the word "A", "An", or "The"
            //These words occur at the end after a comma in the input file for such movies
            if(movieTitleAndYear[0].contains(", The")){
                index=movieTitleAndYear[0].indexOf(", The");
                movieTitle = "The " + movieTitleAndYear[0].substring(0,index);
            }
            //Get the correct format of the title since the word "An" comes at the end after a comma in the input file
            else if(movieTitleAndYear[0].contains(", An")){
                index=movieTitleAndYear[0].indexOf(", An");
                movieTitle = "An " + movieTitleAndYear[0].substring(0,index);
            }
            //Get the correct format of the title since the word "A" comes at the end after a comma in the input file
            else if(movieTitleAndYear[0].contains(", A")){
                index=movieTitleAndYear[0].indexOf(", A");
                movieTitle = "A " + movieTitleAndYear[0].substring(0,index);
            }
            //Get the year of the movie by parsing the year out of the movie details string
            String year_in_string=movieTitleAndYear[1].substring(0,movieTitleAndYear[1].length() - 1);
            int year=Integer.parseInt(year_in_string);
            ArrayList<String> actors= new ArrayList<String>();
            // parse each actor in the movie and create a nicely formatted string as "firstname lastname"
            for(int i=1;i< partsOfStringMovie.length;i++){
                int indexOf = partsOfStringMovie[i].indexOf(", ");
                String name;
                if(indexOf!=-1) {
                    String lastName = partsOfStringMovie[i].substring(0, indexOf);
                    String firstName = partsOfStringMovie[i].substring(indexOf + 2);
                    name= firstName+ lastName;
                }
                else{
                    name=partsOfStringMovie[i];
                }
                //Add each actor field for the movie record into actors list
                actors.add(name);

            }
            //For each actor we create the Actor Graph as we read each movie from the input file
            for (int i = 0; i < actors.size() ; i++) {
                //Create a copy of actor list
                ArrayList<String> costars = (ArrayList<String>) actors.clone();
                //Create the costars adjacency list from this movie record by removing the current actor
                String current_actor = actors.get(i);
                costars.remove(current_actor);
                // We use treeset because we don't want duplicates in the adjacency list
                TreeSet<String> vals = new TreeSet<String>(costars);
                // if this actor is already processed from another movie record add the costars list to the
                // existing adjacency list of costars for this actor otherwise create a new list from the costars in this movie
                if(MovieDatabase.actorAdjList.containsKey(current_actor)) {
                    vals = MovieDatabase.actorAdjList.get(current_actor);
                    vals.addAll(costars);
                }
                //As we read in and process a movie we create the adjacency list of every actors which has their costars in the movie
                //If we already have the actor as a key, we update the adjacency list to include new costars
                MovieDatabase.actorAdjList.put(current_actor, vals);
//
                //Initialize all the KB distances for each actor to a large value
                MovieDatabase.KBDistance.put(current_actor, Integer.MAX_VALUE);

                //As a convenience we also build up a list of all actors in the database
                MovieDatabase.actor_list.add(current_actor);
            }

            // Create a new movie object from the parsed input date and add it to the Moviedatabase instance created
            Movie movie1= new Movie(movieTitle, year, actors);
            movieDatabase.addMovie(movie1);
        }
        //Check the size of movie list and print the 1st movie details to make sure all input is read and processed correctly
        System.out.println(movieList.size() +
                " movies have been imported from the file " +
                "movies-top-grossing-small.txt\n" );
        System.out.println("The first movie is:\n" + movieList.get(0));

//        System.out.println("\nYou'll have to \"split\" the String above to extract the information " +
//                "from it in order to store it as a Movie object." +
//                " You might want to use the split() method in the String class");

        //if we are in small file testing mode, check that we have read all input correctly we can print the adjacency list
        if(USE_SMALL_MOVIE_TEST_FILE){
            System.out.println("Constructed Actor graph for the test movie dataset from the costar adjacency list below:");
            MovieDatabase.actorAdjList.forEach((key, value) -> System.out.println("For Actor: " + key + " Costar Adjacency List:" + value));
        }


        //In small file test mode, we can print out the KB number for each actor using the using the computeKevinBaconNumber method on each movie
        if(USE_SMALL_MOVIE_TEST_FILE){
            movieDatabase.getMovieList().forEach(m -> m.getActors().forEach(a -> System.out.println("Movie is: " + m.getTitle() + " KB Number of Actor: " + a + " is " + m.computeKevinBaconNumber(a))));
        }
        else {

            String[] query_movies = {"Analyze This", "Animal House", "Apollo 13", "Armageddon", "As Good As It Gets"};
            String[] query_actors = {"TonyBennett", "SteveBernie", "BenBode", "BenAffleck", "HelenHunt"};
            for (int i = 0; i < query_movies.length; i++) {
                Movie lm = movieDatabase.getMoviebyTitle(query_movies[i]);
                int num = lm.computeKevinBaconNumber(query_actors[i]);
                System.out.println("Movie is: " + lm.getTitle() + " KB Number of Actor: " + query_actors[i] + " is " + num);

            }

            //We will now test the methods in MovieDatabase class.
            //We will start by testing the search method which returns the titles of movies with a search term(the keyword) in them.
            List<String> keyword1 = movieDatabase.search("2");
            System.out.println("The following movies from the movie database contain 2 in their title: ");
            for (String movie : keyword1) {
                System.out.println(movie);
            }
            List<String> keyword2 = movieDatabase.search("Dalmatians");
            System.out.println("The following movies from the movie database contain Dalmatians in their title: ");
            for (String movie : keyword2) {
                System.out.println(movie);
            }
            List<String> keyword3 = movieDatabase.search("Story");
            System.out.println("The following movies from the movie database contain Story in their title: ");
            for (String movie : keyword3) {
                System.out.println(movie);
            }
            //We will now test the search method which returns the titles of movies with a search term(the keyword) in them.
            List<Movie> moviesWithActor1 = movieDatabase.findMoviesWithActor("ArnoldSchwarzenegger");
            System.out.println("The following movies from the movie database have Arnold Schwarzenegger as an actor in them: ");
            for (Movie movie : moviesWithActor1) {
                System.out.println(movie.toString());
            }
            List<Movie> moviesWithActor2 = movieDatabase.findMoviesWithActor("TomCruise");
            System.out.println("The following movies from the movie database have Tom Cruise as an actor in them: ");
            for (Movie movie : moviesWithActor2) {
                System.out.println(movie.toString());
            }
            List<Movie> moviesWithActor3 = movieDatabase.findMoviesWithActor("KevinBacon");
            System.out.println("The following movies from the movie database have Kevin Bacon as an actor in them: ");
            for (Movie movie : moviesWithActor3) {
                System.out.println(movie.toString());
            }
            //We will now test the getMoviebyTitle method.
            Movie movie1 = movieDatabase.getMoviebyTitle("Total Recall");
            System.out.println(movie1.toString());
            Movie movie2 = movieDatabase.getMoviebyTitle("Speed");
            System.out.println(movie2.toString());
            Movie movie3 = movieDatabase.getMoviebyTitle("Apollo 13");
            System.out.println(movie3.toString());
            //We will creae another database to test all other methods.
            System.out.println("Now we will create a new Movie Database to test methods for single movie");
            MovieDatabase movieDatabase2 = new MovieDatabase();
            List<String> actorsInTheFirm = new ArrayList<String>();
            String[] act_arr = {"MichaelAllen", "JoeyAnderson", "JeaneAufdenberg", "JohnBeal", "TobinBell", "William R.Booth", "ErinBranham", "WilfordBrimley", "ShanBrisendine", "GaryBusey", "PaulCalderon", "JerryChipman", "EdConnelly", "FrankCrawford", "TommyCresswell", "TomCruise", "DavidDwyer", "SusanElliott", "JeffreyFord", "LeviFrazier Jr.", "BarbaraGarrick", "RebeccaGlenn", "GregGoossen", "GeneHackman", "JerryHardin", "EdHarris", "JuliaHayes", "StevenHill", "TeenieHodges", "HalHolbrook", "HollyHunter", "Mark W.Johnson", "DonJones", "JonathanKaplan", "David A.Kimball", "Little JimmyKing", "TerryKinney", "JimmyLackie", "KarinaLombard", "MargoMartindale", "TommyMatthews", "VictorNelson", "OllieNightingale", "DeanNorris", "AfemoOmilami", "Reverend William J.Parham", "JanieParis", "RichardRanta", "ChrisSchadrack", "ClintSmith", "PaulSorvino", "DavidStrathairn", "DeborahThomas", "JeanneTripplehorn", "DebbieTurner", "JoeViterelli", "LouWalker", "SullivanWalker", "JerryWeintraub", "TerriWelles", "JamesWhite", "BartWhiteman"};
            actorsInTheFirm = Arrays.asList(act_arr);
            movieDatabase2.addMovie(new Movie("The Firm", 1993, actorsInTheFirm));
            System.out.println(movieDatabase2.getMovieList());
            System.out.println("The only movie in the list has the title: " + movieDatabase2.getMovieList().get(0).getTitle());
            System.out.println("The only movie in the list is from: " + movieDatabase2.getMovieList().get(0).getYear());
            System.out.println("The only movie in the list has the following actors: " + movieDatabase2.getMovieList().get(0).getActors());
            for (int i = 0; i < act_arr.length; i++) {
                System.out.println("Movie is: " + movieDatabase2.getMovieList().get(0).getTitle() + " KB Number of Actor: " + act_arr[i] + " is " + movieDatabase2.getMovieList().get(0).computeKevinBaconNumber(act_arr[i]));
            }

        }
       /* Your output should look like this:

          188 movies have been imported from the file movies-top-grossing-small.txt

          The first movie is:
          101 Dalmatians (1996)/Benfield, John/Braid, Hilda/Capron, Brian/Close, Glenn/Daniels, Jeff/Evans,
          John/Fraser, Hugh/Haddigan, Mark/Lacey, Joe/Laurie, Hugh/Mason, Margery/McInnerny, Tim/Paris,
          Gerald/Percival, Michael/Peters, John/Phillips, Neville/Plowright, Joan/Readman, Andrew/Richardson,
          Joely/Shrapnel, John/Stewart, Bill/Weiss, Zohren/Welker, Frank/Williams, Mark

          Notice that the title comes first, followed by a space, then the year in parentheses, then a forward
          slash and then the actors separated by forward slashes.

          To earn full credit, you'll have to store the actors' names as FIRST NAME LAST NAME without a space.
          So, Benfield, John would become John Benfield.

          NOTE: Note all names will contain a "comma." For example, Madonna is an actor listed in several movies.



          STEPS FOR COMPLETING MovieRunner class:
            0.  Create a MovieDataBase object using the default constructor
                (it will be empty to start with)
            1.  Create a Movie object for each of the movies in movieList. Notice that the data is read
                from a file and stored temporarily in an ArrayList<String> called movieList.
                This step takes a bit of work. You are extracting information from a String that contains
                all of the information about a Movie.
            2.  Add each Movie object into the MovieDatabase object using the addMovie()
                method in the MovieDatabase class.
            3.  Test that it works: Call each of the methods in the MovieDataBase class.

            You can put all of this code in the main method of this class or you can also write some
            helper methods to make your code more modular.
       */

    }


    private static List<String> readFile(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        List<String> movies = new ArrayList<String>();

        try
        {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {

                movies.add(scanner.nextLine());
            }

            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return movies;
    }
}