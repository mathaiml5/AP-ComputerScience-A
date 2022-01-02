# Person, Student & Teacher

This program implements some simple classes to illustrate the concepts of inheritance, method overriding, and polymorphism.

The Person class stores the name of a person and has various methods including a toString, getter methods, setter methods, and an equals method.

Teacher class contains instance variables storing the student id course and salary for a student (in addition to instance variables inherited for the class Person) and overrrides displayDetails method which prints out a string representation of the private instance variables in Teacher.

Student is a class containing instance variables storing the student's id, course, and teacher name (in addition to instance variables inherited for the class Person) and overrides displayDetails method which prints out a string representation of the private instance variables in Student.

The Person_Main Runner class tests various methods and constructors from the Student, Teacher, and Person classes.

Below is shown the class diagram with the methods and inheritance details.
![Vehicle Owner Class Diagram](https://github.com/mathaiml5/AP-ComputerScience-A/blob/main/Person/images/person-uml.png?raw=true)
