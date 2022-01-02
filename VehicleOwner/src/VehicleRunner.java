import java.sql.SQLOutput;

/**
 * The Vehicle Runner class tests methods ,and constructors from the Truck, Vehicle ,and Person classes.
 *
 * @author Vishak Srikanth
 * @version 1/27/21
 */
public class VehicleRunner {
    public static void main(String[] args) {
        System.out.println("First, we will test the methods in the Person class.");
        Person Person1 = new Person();
        System.out.println("After Person1 is initialized using a no-argument constructor, Person1's name is "
                + Person1.getName() + "." );
        Person1.setName("George Washington");
        System.out.println("After using a setter method, Person1's name is " + Person1.getName() + "." );
        System.out.println("The toString method, when run on Person1 outputs: ");
        System.out.println(Person1.toString());
        Person Person2 = new Person("John Adams");
        System.out.println("After Person2 is initialized using a constructor, Person's name is "
                + Person2.getName() + "." );
        System.out.println("The toString method, when run on Person2 outputs: ");
        System.out.println(Person2.toString());
        System.out.println("The equals method, when comparing Person1 and Person2 outputs: ");
        System.out.println(Person2.equals(Person1));
        Person Person3 = new Person(Person2);
        System.out.println("After Person3 is initialized using a constructor, Person's name is "
                + Person3.getName() + "." );
        System.out.println("Now, we will test the methods in the Vehicle class.");
        Vehicle vehicle1 = new Vehicle("Toyota",5,"George Washington");
        System.out.println("After a constructor is used, vehicle 1's owner, manufacturer's name ,and number of cylinders in the engine  are, respectively "
                + vehicle1.getOwnerName() + ", " + vehicle1.getManufacturerName() +", and "+ vehicle1.getNumberOfCylinders() + ".");
        Person owner = new Person("Thomas Jefferson");
        vehicle1.setOwner(owner);
        vehicle1.setManufacturerName("Honda");
        vehicle1.setNumberOfCylinders(1);
        System.out.println("The number of cylinders, the manufacturer name ,and owner are now "
                + vehicle1.getNumberOfCylinders() + ", " + vehicle1.getManufacturerName()+ ", and" + vehicle1.getOwnerName());
        System.out.println("The getOwner method outputs:");
        System.out.println(vehicle1.getOwner());
        System.out.println("The toString method outputs: ");
        System.out.println(vehicle1.toString());
        Vehicle vehicle2 = new Vehicle();
        System.out.println("Initially, the equals method outputs: ");
        System.out.println(vehicle1.equals(vehicle2));
        System.out.println("Initially, the toString method outputs: ");
        System.out.println(vehicle2.toString());
        Person owner2 = new Person("James Monroe");
        vehicle2.setOwner(owner2);
        vehicle2.setManufacturerName("Tesla");
        vehicle2.setNumberOfCylinders(2);
        System.out.println("The number of cylinders, the manufacturer name ,and owner are now "
                + vehicle1.getNumberOfCylinders() + ", " + vehicle1.getManufacturerName()+ ", and" + vehicle1.getOwnerName());
        System.out.println("Now, the equals method outputs: ");
        System.out.println(vehicle1.equals(vehicle2));
        System.out.println("Now, the toString method outputs: ");
        System.out.println(vehicle2.toString());
        Person owner3 = new Person("Andrew Jackson");
        Vehicle vehicle3 = new Vehicle("Volkswagen",6,owner3);
        System.out.println("Now, the equals method outputs: ");
        System.out.println(vehicle1.equals(vehicle3));
        System.out.println("Now, the toString method outputs: ");
        System.out.println(vehicle3.toString());
        System.out.println("Finally, we will test the methods in the Truck class.");
        Truck truck1 = new Truck();
        System.out.println("Initially, the toString method outputs:");
        System.out.println(truck1.toString());
        System.out.println("The number of cylinders, the manufacturer name ,load capacity, towing capacity and owner are now "
                + truck1.getNumberOfCylinders() + ", " + truck1.getManufacturerName()+ ", " + truck1.getLoadCapacity() + ", "
                +truck1.getTowingCapacity() +", and" + truck1.getOwnerName());
        Person person4 =new Person();
        System.out.println("The equals method as applied to truck 1 and person 4 outputs: ");
        System.out.println(person4.equals(truck1));
        truck1.setNumberOfCylinders(4);
        truck1.setManufacturerName("Ford");
        truck1.setLoadCapacity(4.0);
        truck1.setTowingCapacity(1000);
        truck1.setOwner("John Quincy Adams");
        System.out.println("Now, the toString method on truck1 outputs: ");
        System.out.println(truck1.toString());
        Truck truck2 = new Truck(8.0 ,9);
        System.out.println("The toString method on truck2 outputs: ");
        System.out.println(truck2.toString());
        System.out.println("Using the equals method for comparing trucks 1 and 2 outputs: ");
        System.out.println(truck2.equals(truck1));
        Person owner4 = new Person("Martin Van Buren");
        Truck truck3 = new Truck(7.6 ,4,"Cheverolet",3,owner4);
        System.out.println("The toString method on truck3 outputs: ");
        System.out.println(truck3.toString());
        System.out.println("Using the equals method for comparing trucks 1 and 3 outputs: ");
        System.out.println(truck3.equals(truck1));
        System.out.println("Using the get owner method on truck 3 outputs: ");
        System.out.println(truck3.getOwner());
        Truck truck4 = new Truck(7.6 ,4,"Cheverolet",3, "James Polk");
        System.out.println("The toString method on truck4 outputs: ");
        System.out.println(truck4.toString());
        System.out.println("Using the equals method for comparing trucks 1 and 4 outputs: ");
        System.out.println(truck4.equals(truck1));
        System.out.println("Using the get owner method on truck 4 outputs: ");
        System.out.println(truck4.getOwner());


    }
}
