/**
 * The Vehicle class stores the name of the owner of a vehicle, the number of cylinders a vehicle's engine has, and
 * the manufacturer of a vehicle and has various methods including a toString, getter methods, setter methods, and an
 * equals method.
 *
 * @author Vishak Srikanth
 * @version 1/27/21
 */
public class Vehicle {
    private String manufacturerName;
    private int numberOfCylinders;
    private Person owner;
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle() {
        manufacturerName = "";
        numberOfCylinders = 0;
        owner = new Person();
    }
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String manufacturerName,int numberOfCylinders,Person owner ) {
        this.manufacturerName = manufacturerName;
        this.numberOfCylinders = numberOfCylinders;
        this.owner = owner;
    }
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String manufacturerName,int numberOfCylinders,String name ) {
        this.manufacturerName = manufacturerName;
        this.numberOfCylinders = numberOfCylinders;
        owner = new Person(name);
    }


    /**
     * getManufacturerName(): a getter method for manufacturer name
     * @param: none
     * @return: manufacturerName( a string): the manufacturer of a vehicle
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * setManufacturerName(): a setter method for manufacturer name
     * @param: manufacturerName( a string)
     * @return: none
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
    /**
     * getNumberOfCylinders(): a getter method for number of cylinders
     * @param: none
     * @return: number of cylinders: the number of cylinders in a vehicle's engine (an integer)
     */
    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }
    /**
     * setNumberOfCylinders(): a setter method for number of cylinders
     *@param: numberOfCylinders( an integer)
     *@return: none
     */
    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }
    /**
     * getOwner(): a getter method for the owner
     * @param: none
     * @return: owner: the vehicle's owner (an object of class person)
     */
    public Person getOwner() {
        return owner;
    }
    /**
     * getOwnerName(): a getter method for the owner
     * @param: none
     * @return: ownerName: the name of the owner of a vehicle( a String)
     */
    public String getOwnerName() {
        return owner.getName();
    }
    /**
     * setOwnerName(): a setter method for the person object containing the owner of the vehicle's name
     *@param: owner( an object of class Person)
     *@return: none
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }
    /**
     * setOwner(): a setter method for the the owner of the vehicle's name
     *@param: name( a string)
     *@return: none
     */
    public void setOwner(String name) {
        owner.setName(name);
    }
    /**
     * toString(): a toString method for class Vehicle
     * @param: none
     * @return: a string representation of objects of class Vehicle
     */
    public String toString() {
        return "The vehicle is made by " + manufacturerName + " and has " + numberOfCylinders + " cylinders in the" +
                " engine. The vehicle is owned by " +owner.getName() +".";
    }

    /**
     * equals(): an equals method comparing objects of class Vehicle to other objects
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
        // the objects must have the same manufacturer name, number of cylinders, ,and owner's name
        // field to be equal
        else{
            return((this.manufacturerName.equals(((Vehicle)other).getManufacturerName())) && (numberOfCylinders==
                    ((Vehicle) other).getNumberOfCylinders()) && (this.getOwnerName().equals(((Vehicle)other).
                    getOwnerName())) );
        }
    }
}
