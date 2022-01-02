import com.sun.istack.internal.NotNull;

import java.util.Objects;
/**
 * The Person class stores the name of a person and has various methods including a toString, getter methods, setter methods, and an equals method.
 *
 * @author Vishak Srikanth
 * @version 1/27/21
 */
public class Person {
    private String name;
    /**
     * Constructor for objects of class Person
     */
    public Person(){
        name = "";
    }

    /**
     * Constructor for objects of class Person
     */
    public Person(String theName){
        name = theName;
    }
    /**
     * Constructor for objects of class Person
     */
    public Person(Person theObject){
        name = theObject.getName();
    }

    /**
     * getName(): a getter method for name
     * @param: none
     * @return: name( a string): the name of a person
     */
    public String getName() {
        return name;
    }
    /**
     * setName(): a setter method for name, the name of a person
     * @param: name(a string)
     * @return: none
     */
    public void setName(String theName){
        this.name = theName;
    }

    /**
     * toString(): a tosString method for class Person
     * @param: none
     * @return: a string representation of objects of class person
     */
    public String toString(){
        //include the person's name in a toString representation
        return "The person's name is " + this.name + ".";
    }
    /**
     * equals(): an equals method comparing objects of class Person to other objects
     * @param other (an object)
     * @return
     */
    @Override
    public boolean equals(Object other) {
        //if an object is a null object, then applying the getClass method on it throws a null pointer exception so
        //we have to deal with this case separately
        if(other==null){
            return false;
        }
        //an object will only have a name instance variable if the object is an object of class person or the
        //object contains or is derived from an object of class person( two objects must be from the same class to be equal)
        else if(this.getClass()!=(other.getClass())){
            return false;
        }
        // the objects must have the same name field to be equal
        else{
           return(this.getName().equals(((Person)(other)).getName()));
        }
    }
}
