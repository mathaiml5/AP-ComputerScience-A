
/**
 * Student is a class containing instance variables storing the student id course and teacher name for a student(in addition to instance variables 
 * inherited for the class Person) ,in addition to having a displayDetails method 
 * which prints out a spring representation of the private instance variables in Teacher.
 *
 * @author Vishak Srikanth
 * @version 1/20/21
 */
public class Student extends Person
{
    private int student_id;
    private String course;
    private String teacher_name;
    
    

    /**
     * Constructor for objects of class Student
     * This constructor is a no argument constructor.
     */
    public Student()
    {
      super();
      student_id = 0;
      course = "";
      teacher_name = "";
    }
    /**
     * Constructor for objects of class Student
     * This constructor takes in a first name and a last name and creates an object of class Student.
     */
    public Student(String first_name, String last_name)
    {
      super(first_name,last_name);
      student_id = 0;
      course = "";
      teacher_name = "";
    }
    /**
     * Constructor for objects of class Student
     * This constructor takes in a student id, a course, and a teacher name and creates an object of class Student.
     */
    public Student(int student_id, String course, String teacher_name)
    {
      super();
      this.student_id = student_id;
      this.course = course;
      this.teacher_name = teacher_name;
    }
    /**
     * Constructor for objects of class Student
     * This constructor takes in a first name, a last name, a student id, a course, and a teacher name and creates an object of class Student.
     */
    public Student(String first_name, String last_name,int student_id,
    String course, String teacher_name)
    {
      super(first_name, last_name);
      this.student_id = student_id;
      this.course = course;
      this.teacher_name = teacher_name;
    }
    /**
     * getStudentId: a getter method for the private instance variable student_id
     *
     * @return student_id: a string
     */
    public int getStudentId()
    {
        return student_id;
    }
    /**
     * setStudentId: a setter method for the private instance variable student_id
     *
     * @param  student_id: a string which you want to set student_id ( a private instance variable) to
     * @return   none
     */
    public void setStudentId(int student_id)
    {
        this.student_id = student_id;
    }
    /**
     * getCourse: a getter method for the private instance variable course
     *
     * @return course: a string
     */
    public String getCourse()
    {
        return course;
    }
    /**
     * setCourse: a setter method for the private instance variable course
     *
     * @param    course a string which you want to set coursw( a private instance variable) to
     * @return   none
     */
    public void setCourse(String course)
    {
        this.course = course;
    }
    /**
     * getTeacherName: a getter method for the private instance variable teacher_name
     *
     * @return teacher_name: a string
     */
    public String getTeacherName()
    {
        return teacher_name;
    }
    /**
     * setTeacherName: a setter method for the private instance variable teacher_name
     *
     * @param teacher_name string which you want to set teacher_name( a private instance variable) to
     * @return none
     */
    public void setTeacherName(String teacher_name)
    {
        this.teacher_name = teacher_name;
    }
    /**
     * The display details method prints the values of the instance variables from the Student class in string format( including instance variables 
     * inherited from the Person class).
     *
     * @return none
     * prints details( a string version of the values of the instance variables from the Student class( including those inherited from the Person class))
     */
    @Override
    public void displayDetails()
    {
       String details = "The student's name is " + (super.getFirstName().equals("") ? "<not set>" : super.getFirstName())
       + " " + (super.getLastName().equals("") ? "<not set>" : super.getLastName()) + ". The Student also has the id number "
       + student_id + " and is in the course " + course 
       + ", and has a teacher whose name is "+ teacher_name + "." ; 
        System.out.println(details);
    }
}
