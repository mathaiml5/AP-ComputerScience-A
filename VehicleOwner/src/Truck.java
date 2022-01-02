/**
 * The Truck class stores in addition to the name of the owner of a vehicle, the number of cylinders a vehicle's engine has, and
 * the manufacturer of a vehicle which are inherited from the vehicle class and contains additional variables including
 * load capacity and towing capacity of a truck and has various methods including a toString, getter methods,
 * setter methods, and an equals method.
 *
 * @author Vishak Srikanth
 * @version 1/27/21
 */
public class Truck extends Vehicle{
    private double loadCapacity;
    private int towingCapacity;
    /**
     * Constructor for objects of class Person
     */
    public Truck(){
        super();
        loadCapacity = 0.0;
        towingCapacity = 0;
    }
    /**
     * Constructor for objects of class Truck
     */
    public Truck(double loadCapacity, int towingCapacity){
        super();
        this.loadCapacity = loadCapacity;
        this.towingCapacity = towingCapacity;
    }
    /**
     * Constructor for objects of class Truck
     */
    public Truck(double loadCapacity, int towingCapacity, String manufactureName, int numberOfCylinders, Person Owner ){
        super(manufactureName, numberOfCylinders, Owner);
        this.loadCapacity = loadCapacity;
        this.towingCapacity = towingCapacity;
    }
    /**
     * Constructor for objects of class Truck
     */
    public Truck(double loadCapacity, int towingCapacity, String manufactureName, int numberOfCylinders, String OwnerName ){
        super(manufactureName, numberOfCylinders, OwnerName);
        this.loadCapacity = loadCapacity;
        this.towingCapacity = towingCapacity;
    }

    /**
     * getLoadCapacity(): a getter method for load capacity
     * @param: none
     * @return: loadcapacity( a double): the loadcapacity of a truck
     */
    public double getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * setLoadCapacity(): a setter method for load capacity, the load a truck can carry
     * @param: loadCapacity( a double)
     * @return: none
     */
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    /**
     * getTowingCapacity(): a getter method for towing capacity
     * @param: none
     * @return: towing capacity(integer): the towing capacity of a truck
     */
    public int getTowingCapacity() {
        return towingCapacity;
    }

    /**
     * setTowingCapacity(): a setter method for towing capacity, how much a truck can tow
     * @param: towingCapacity(integer)
     * @return: none
     */
    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }
    /**
     * toString(): a toString method for class Truck
     * @param: none
     * @return: a string representation of objects of class person
     */
    @Override
    public String toString(){
        return "The truck is made by " + super.getManufacturerName() + " and has " + super.getNumberOfCylinders()
                + " cylinders in the engine. The truck is owned by " +super.getOwnerName() +". The truck has a load "
                + "capacity of " + this.getLoadCapacity() +" and a towing capacity of " + this.getTowingCapacity()
                + " pounds.";
    }
    /**
     * equals(): an equals method comparing objects of class Truck to other objects
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
        // the objects must have the same manufacturer name, number of cylinders, towing capacity, owner's name ,and
        // load capacity field to be equal
        else{
            return((this.getManufacturerName().equals(((Truck)other).getManufacturerName())) && (this.getNumberOfCylinders()==
                    ((Truck) other).getNumberOfCylinders()) && (this.getOwnerName().equals(((Vehicle)other).
                    getOwnerName())) && (this.getLoadCapacity()==(((Truck)other).getLoadCapacity())) &&
                    (this.getTowingCapacity()==(((Truck)other).getTowingCapacity())));
        }
    }
}
