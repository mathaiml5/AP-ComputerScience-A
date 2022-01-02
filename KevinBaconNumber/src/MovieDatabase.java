import java.util.*;

/**
 * MovieDatabase is a collection of Movie objects. It allows a client to store movies and
 * perform operations on the movies for each instance of a MovieDatabase.
 *
 * Vishak Srikanth
 * @version 4/6/2021
 */
public class MovieDatabase
{
    //As a convenience, I have made several variables public and static static so you don't need to create
    //a Moviedatabase instance to run the DFS search or compute KB number or even look at all the actors in the DB
    List<Movie> movieList;  // a List of all Movie objects
    //To compute the KB number I am using a few data structures:
    // 1. I create an adjacency list of the actor graph which has which actors have acted together with another actor in any of the movies
    // in the database. I use a TreeMap to store the adjacency list (value) for each actor (key). treemap is used so key
    // are in sorted order  as a convenience
    // 2. I have a TreeMap that stores the computed KB distnaces (value) for each actor (key). treemap is used so key
    // are in sorted order  as a convenience
    // 3. I also have a static variable for all actors in the MovieDatabase for convenience
    // The Actor Graph is a set of nodes which is stored in adjacency list format as a treeMap (which is sorted by its keys)
    // where each entry has the actor name as key and the value is the treeset of all actors that have acted with the
    // given actor in any movie in this database
    // Note: value is a treeset because we don't care about duplicates (i.e. we could have the same set of 2 actors costarring
    // in multiple movies but we don't want to redundantlty store this info or traverse this during the BFS search
    public static TreeMap<String, TreeSet<String>> actorAdjList = new TreeMap<String, TreeSet<String>>();
    //We store all the computed KB distances for each actor in a Treemap with actor name as the key and computed KB distance as value
    public static TreeMap<String, Integer> KBDistance = new TreeMap<String, Integer>();
    // We store all actors that appear in any movie in the MovieDatabase as a Treeset (to avoid duplicates)
    public static TreeSet<String> actor_list = new TreeSet<String>();

    /**
     * initializes a MovieDatabase -- the database starts empty
     */
    public MovieDatabase()
    {
        movieList= new ArrayList<Movie>();
    }


    /**
     * getMovieList(): getter method for movieList
     * @return movieList: an arraylist containing the names of actors in a movie
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * addMovie(Movie movie):
     * Adds a movie to the database
     * @paramL movie, a Movie to add to the database
     */
    public void addMovie(Movie movie)
    {
        movieList.add(movie);
    }

    /**
     * search(String keyword):
     * Searches the database for Movie titles that contains keyword.
     * If a movie is not found, return an empty ArrayList.
     * For example, search("Dalmation") returns an ArrayList containing
     * one movie: ["101 Dalmations"]
     * @param: keyword, a string
     * @return: moviesWithKeyword, a list of strings
     */
    public List<String> search(String keyword)
    {
        //create an empty arraylist of strings to put the movie titles containing the keyword in
        ArrayList<String> moviesWithKeyword = new ArrayList<String>();
        //For each movie in the database, check if the movie's title contains the keyword and if so add the movie's title to the arraylist created above
        for(Movie movie: movieList){
            if(movie.getTitle().contains(keyword)){
                moviesWithKeyword.add(movie.getTitle());
            }
        }
        return moviesWithKeyword;
    }

    /**
     * getMoviebyTitle(String movieName): returns a Movie object with the requested title
     * @param movieName, a string
     * @return result, a Movie
     */
    public Movie getMoviebyTitle(String movieName)
    {
        Movie result = null; // = new Movie("", -1, new List<String>();
        //look at all movies in the movieList and if the move has the same title as the variable movieName, which is an argument for this method, return that movie
        for(Movie movie: movieList){
            if(movie.getTitle().equals(movieName)){
                result = movie;
            }
        }
        return result;
    }






    /**
     * Returns a List of all Movie objects in which a person acted.
     * The actor's name must be an exact match. For example, searching for
     * "Cruise" would return an empty list, while searching for
     * "Tom Cruise" would return the correct list of actors.
     * findMoviesWithActor(String person):
     * returns the movies containing the specified actor
     * @param: person, a string
     * @return: moviesWithActor, a list of Movie objects for which the movies have the specified actor
     */
    public List<Movie> findMoviesWithActor(String person)
    {
        //create an empty arraylist of strings to put the movie titles with the keyword in
        ArrayList<Movie> moviesWithActor = new ArrayList<Movie>();
        //look through the movies in the movieList and if the movie has the specified person as an actor in it add the movie's title to the arraylist created above
        for(Movie movie: movieList){
            if(movie.getActors().contains(person)){
                moviesWithActor.add(movie);
            }
        }
        return moviesWithActor;
    }
}
