import java.util.*;

/**
 * A Movie object encapsulates data about a particular movie.
 *
 * @author Vishak Srikanth
 * @version 4/6/2021
 */
public class Movie
{
    // data fields
    private String title;   // the title of the movie
    private int year;       // the year of the movie was released
    private List<String> actors; // a List of the main actors in the movie


    /**
     * Constructor for objects of class Movie
     */

    public Movie(String name, int year, List<String> a){
        title=name;
        this.year=year;
        actors = new ArrayList<String>();
        actors.addAll(a);
    }

    /**
     * getTitle():
     * returns the title of the movie(a getter method for title)
     * @return: title, the title of a movie(a string)
     */
    public String getTitle()
    {

        return title;
    }

    /**
     * getYear():
     * returns the year the movie was released(a getter method for year)
     *  @return: year, the year of a movie(an integer)
     */
    public int getYear()
    {

        return year;
    }

    /**
     * getActors():
     * returns a List of all the main actors in the movie(a getter method for actors)
     * @return: actors, a List of actors
     */
    public List<String> getActors()
    {

        return actors;
    }

    /**
     * toString():
     * returns a String representation of a Movie object in the format:
     *
     *Title: 101 Dalmatians
     *Year: 1999
     *Actors : [John Benfield, ... , Mark Williams]
     * @return: a string representation of the Movie object
     */
    public String toString()
    {

        return "Title:" + title + "\n" + "Year:" + year + "\n"  + "Actors:" + actors;
    }


    /**
     * computeKevinBaconNumber(): computes the Kevin Bacon number of an actor, based on the movies-top-grossing file
     * @param person : an actor from the movie
     * @return: integer which represents the distance (or degree of separation) from Kevin Bacon based on actor graph
     *
     * CHALLENGE (this is NOT trivial and NOT required as part of this assignment)
     * computes the Kevin Bacon number of an actor
     * https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon#Bacon_numbers
     *
     * This method uses Breadth First Search (BFS) to run thru' all connected nodes from the node
     * for which we need KB number using the actor graph created when we read in all the movies into the database
     * During BFS, we traverse nodes 1 level at a time using the adjacency list of actors in the graph
     * Note: This is not the ideal place to have this method since we need to look globally at all movies to traverse all
     * relevant actors and compute the Distnce but since the problem required it be placed here, I put it here.
     * I think it is better to make this a static method on MovieDatabase class so one can invoke it on any actor without
     * having to work from a given movie's actors.
     */

    int computeKevinBaconNumber(String person){
        //First we check if the current actor is Kevin Bacon, if so the distance is 0
        if(person.equals("KevinBacon")) {
            return 0;
        }


        Queue<String> queue = new LinkedList<String>();
        //If current actor is not KB, we add the current actor to a
        // queue (which has all the unvisited nodes of the crawling from current node)
        // set KB distance of current actor to 0
        //Then we do a BFS traversal of the actor graph using the adjacency list
        String mainActor = new String(person);
        MovieDatabase.KBDistance.put(person, 0);
        queue.add(mainActor);
        Set<String> visited = new HashSet<String>();
        visited.add(person);
        //When the adjacency list to be crawled is not empty
        while(!queue.isEmpty()) {
            //Get the earliest inserted element at head of queue
            String last = queue.remove();
            //If the head of the queue already is KB then return the distance of this node
            if(last.equals("KevinBacon"))  {
                return MovieDatabase.KBDistance.get(last);
            }
            //If not, iterate thru' all the adjacent nodes in the graph for the current head element of queue
            for(String node: MovieDatabase.actorAdjList.get(last)) {
                //If a node in the adjacency list has not been visited already
                if(!visited.contains(node)) {
                    //Now we have moved 1 level in the graph, so we need to add 1 to the adjacency node's distance
                    MovieDatabase.KBDistance.put(node, MovieDatabase.KBDistance.get(last) + 1);
                    //Add the adjacent node to queue and mark it as visited
                    queue.add(node);
                    visited.add(node);
                }

            } //Each of these loops thru' adjacency lists of a node 1 level at a time
        } //Once we have an empty queue we have exhausted all the paths
        //If we have exhausted all the paths and are here, it means the person node is not connectd to KB through the actor graph
        //so we return -1
        return -1;
    }






}

