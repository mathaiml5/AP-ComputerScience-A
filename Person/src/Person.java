
/**
 * Person is a class containing instance variables storing the first and last name of a person ,in addition to having a displayDetails method 
 * which prints out a spring representation of the private instance variables in Person.
 *
 * @author Vishak Srikanth
 * @version 1/20/21
 */
public class Person
{
    
    private String first_name;
    private String last_name;
       
    /**
     * Constructor for objects of class Person
     * This constructor is a no argument constructor.
     */
    public Person()
    {
        first_name = "";
        last_name = "";
    }
    /**
     * Constructor for objects of class Person
     * This constructor takes in a first name and a last name and creates an object of class Person.
     */
    public Person(String first_name, String last_name)
    {
        this.first_name = first_name ;
        this.last_name = last_name;
    }
    /**
     * The display details method prints the values of the instance variables from the Person class in string format.
     *
     * @return none
     * prints details( a string version of the values of the instance variables from the Person class)
     */
    public void displayDetails()
    {
        String details = "The person's name is " + (first_name.equals(null) ? "<not set>" : first_name) + " "
        + (last_name.equals(null) ? "<not set>" : last_name);
        System.out.println(details);
    }
    /**
     * getFirstName: a getter method for the private instance variable first_name
     *
     * @return   first_name: a string
     */
    public String getFirstName()
    {
        return first_name;
    }
    /**
     * setFirstName: a setter method for the private instance variable first_name
     *
     * @param    first_name: a string which you want to set first_name( a private instance variable) to
     * @return   none
     */
    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }
    /**
     * getLastName: a getter method for the private instance variable last_name
     *
     * @return last_name: a string
     */
    public String getLastName()
    {
        return last_name;
    }
    /**
     * setFirstName: a setter method for the private instance variable last_name
     *
     * @param  last_name: a string which you want to set last_name( a private instance variable) to
     * @return none
     */
    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }
    
}
