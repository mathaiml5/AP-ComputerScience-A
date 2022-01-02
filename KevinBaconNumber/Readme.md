# Movie Database & Kevin Bacon Number

This assignment introduces several Java data structures such as TreeSets and ArrayLists and illustrates how to store and traverse a connected graph.

A database of top grossing movies from a source such as IMDB is cerated that can then queried by various fields such as year, actors, or titles is built. For each actor we are also interested in computing their [Kevin Bacon Number](https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon#Bacon_numbers) which is an integer which represents the distance (or degree of separation) from Kevin Bacon based on movies that he has costarred with other actors which is internally stored as a graph

The MovieDatabase class is created by reading a set of records from a movie list text file that has each movie's data in the following format: 

* 101 Dalmatians (1996)/Benfield, John/Braid, Hilda/Capron, Brian/Close, Glenn/Daniels, Jeff/Evans, John/Fraser, Hugh/Haddigan, Mark/Lacey, Joe/Laurie, Hugh/Mason, Margery/McInnerny, Tim/Paris, Gerald/Percival, Michael/Peters, John/Phillips, Neville/Plowright, Joan/Readman, Andrew/Richardson, Joely/Shrapnel, John/Stewart, Bill/Weiss, Zohren/Welker, Frank/Williams, Mark

Notice that the title comes first, followed by a space, then the year in parentheses, then a forward slash and then the actors separated by forward slashes.

NOTE: Note all names will contain a "comma." For example, Madonna is an actor listed in several movies.

Corresponding to each record read we create a Movie object and populate its fields. Once the MovieDatabase is built we can compute for each actor their "Kevin Bacon Number" using a Breadth First Traversal of the actor graph that is created as the data base is built.

The key elements of the design are as follows:

1. First we build a MovieDatabase by reading records and populating the relevant fields. The actor names are parsed and after removing spaces stored as TreeMap. 
2. The Actor Graph is a set of nodes which is stored in adjacency list format as a treeMap (which is sorted by its keys) where each entry has the actor name as key and the value is the treeset of all actors that have acted with the given actor in any movie in this database
3. We create an adjacency list for storing the actor graph which has which actors have acted together with another actor in any of the movies in the database using a TreeMap to store the adjacency list (which is actors that are costars as the value) for each actor ( which is the key). Treemap is used so keys are in sorted natural order (alphabetical) and we do not need to sort them after the fact.
4. Another TreeMap stores the computed KB distances (as value) for each actor (as key) for all actors in the MovieDatabase. Treemap is used so keys are in sorted order as a convenience Note: We use Treeset data structure because we don't care about duplicates (for e.g. we could have the same set of 2 actors costarring in multiple movies but we don't want to redundantlty store this info in the adjacencyList or traverse this multiple times during the BFS search)
5. The method computeKevinBaconNumber() uses Breadth First Search (BFS) to run thru' all connected nodes from the actor for whom we need their KB number using the actor graph created. During BFS, we traverse nodes 1 level at a time using the adjacency list of actors in the graph.
6. The movieList is stored as an ArrayList of Movie objects as we want a dynamically sized list based on the number of movies in the input file.
    
