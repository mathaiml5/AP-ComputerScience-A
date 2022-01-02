
/**
 * Teacher is a class containing instance variables storing the subject_name and salary for a teacher (in addition to instance variables
 * inherited for the class Person) and overrides isplayDetails method
 * which prints out a string representation of the private instance variables in Teacher.
 *
 * @author Vishak Srikanth
 * @version 1/20/21
 */
public class Teacher extends Person
{
    private String subject_name; 
    private double salary;
    //I used a double so that both dollars and cents could be represented 
    //in the salary.
    /**
     * Constructor for objects of class Teacher
     * This is a no argument constructor.
     */
    public Teacher()
    {

        super();
        subject_name = "";
        salary = 0.00;
    }
    /**
     * Constructor for objects of class Teacher
     * This constructor has arguments subject_name and salary.
     */
        public Teacher(String subject_name, double salary)
    {
        super();
        this.subject_name = subject_name;
        this.salary = salary;
    }
    /**
     * Constructor for objects of class Teacher
     * This constructor has arguments subject_name, salary, first_name, and last_name.
     */
        public Teacher(String first_name, String last_name, 
        String subject_name, double salary)
    {

        super(first_name, last_name);
        this.subject_name = subject_name;
        this.salary = salary;
    }
    /**
     * Constructor for objects of class Teacher
     * This constructor has arguments first_name and last_name.
     */
        public Teacher(String first_name, String last_name)
    {

        super(first_name, last_name);
        subject_name = "";
        salary = 0.00;
    }
     /**
     * getSubjectName: a getter method for the private instance variable subject_name
     *
     * @return subject_name( a string)
     */
    public String getSubjectName()
    {
        // put your code here
        return subject_name;
    }
     /**
     * setSubjectName: a setter method for the private instance variable subject_name
     *
     * @param  subject_name: a string which you want to set subject_name( a private instance variable) to
     * @return none
     */
    public void setSubjectName( String subject_name)
    {
        this.subject_name = subject_name;
    }
     /**
     * getSalary: a getter method for the private instance variable salary
     *
     * @return salary( a double)
     */
    public double getSalary()
    {

        return salary;
    }
    /**
     * setSalary: a setter method for the private instance variable salary
     *
     * @param   salary a double which you want to set salary( a private instance variable) to
     * @return  none
     */
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    /**
     * The display details method prints the values of the instance variables from the Teacher class in string format( including instance variables 
     * inherited from the Person class).
     *
     * @return none
     * orints details( a string version of the values of the instance variables from the Teacher class( including those inherited from the Person class))
     */
    @Override
    public void displayDetails()
    {
        String details = "The teacher's name is " + super.getFirstName() + " " + super.getLastName() + ". The teacher teaches " + subject_name 
        +" and has a salary of $" + salary + "."  ;
        System.out.println(details);
    }
}
