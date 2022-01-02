
/**
 * The Person_Main class tests the Person, Student, and Teacher classes by creating object of the Student ,and Teacher class and running methods 
 * such as displayDetails on the objects.
 *
 * @author Vishak Srikanth
 * @version 1/20
 */
public class Person_Main
{
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("After student1 has been intialized by a no-argument constructor, the method displayDetails outputs: ");
        student1.displayDetails();
        student1.setFirstName("Ada");
        student1.setLastName("Lovelace");
        student1.setStudentId(101);
        student1.setCourse("AP Computer Science A");
        student1.setTeacherName("Charles Babbage");
        System.out.println("We will now test the getter methods by printing out the student1's first name, last name, student id, course,and teacher's"
        +" name, respectively.");
        System.out.println(student1.getFirstName());
        System.out.println(student1.getLastName());
        System.out.println(student1.getStudentId());
        System.out.println(student1.getCourse());
        System.out.println(student1.getTeacherName());
        System.out.println("Now, displayDetails outputs: ");
        student1.displayDetails();
        Student student2 = new Student("John", "Adams", 102,"AP US History", "Thomas Jefferson");
         System.out.println("We will now test the getter methods by printing out the student2's first name, last name, student id, course,and teacher's"
        +" name, respectively.");
        System.out.println(student2.getFirstName());
        System.out.println(student2.getLastName());
        System.out.println(student2.getStudentId());
        System.out.println(student2.getCourse());
        System.out.println(student2.getTeacherName());
        System.out.println("After student2 has been intialized by a constructor, the method displayDetails outputs: ");
        student2.displayDetails();
        System.out.println("Now, we will change the private instance variables for student2 by using setter methods. ");
        student2.setFirstName("James");
        student2.setLastName("Madison");
        student2.setStudentId(104);
        student2.setCourse("AP US Government and Politics");
        student2.setTeacherName("James Monroe");
        System.out.println("Now, displayDetails outputs: ");
        student2.displayDetails();
        Teacher teacher1 = new Teacher();
        System.out.println("After teacher1 has been intialized by a no-argument constructor, the method displayDetails outputs: ");
        teacher1.displayDetails();
        teacher1.setFirstName("Andrew");
        teacher1.setLastName("Jackson");
        teacher1.setSubjectName("Physics");
        teacher1.setSalary(56999.99);
        System.out.println("We will now test the getter methods by printing out the teacher1's first name, last name, subject name, and salary"
        +", respectively.");
        System.out.println(teacher1.getFirstName());
        System.out.println(teacher1.getLastName());
        System.out.println(teacher1.getSubjectName());
        System.out.println(teacher1.getSalary());
        System.out.println("Now, displayDetails outputs: ");
        teacher1.displayDetails();
        Teacher teacher2 = new Teacher("Charles","Darwin","Chemistry",99999.99);
        System.out.println("After teacher2 has been intialized by a constructor, the method displayDetails outputs: ");
        teacher2.displayDetails();
        teacher2.setFirstName("Gregory");
        teacher2.setLastName("Mendel");
        teacher2.setSubjectName("Biology");
        teacher2.setSalary(89999.98);
        System.out.println("We will now test the getter methods by printing out the teacher2's first name, last name, subject,and salary"
        +", respectively.");
        System.out.println(teacher2.getFirstName());
        System.out.println(teacher2.getLastName());
        System.out.println(teacher2.getSubjectName());
        System.out.println(teacher2.getSalary());
        System.out.println("Now, displayDetails outputs: ");
        teacher2.displayDetails();
    }
}
