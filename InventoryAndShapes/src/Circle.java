/**
 * Circle is a class which uses the Shape interface, which is used to calculate the area of and create circle objects.
 *
 * @author Vishak Srikanth
 * @version 2/23/2021
 */
import java.lang.Math;
public class Circle implements Shape {
    private double radius;
    /**
     * No-argument constructor for objects of class Circle
     */
    public Circle() {
        radius = 0;
    }
    /**
     * constructor for objects of class Circle
     */
    public Circle(double radius){
        this.radius = radius;
    }

    /**
     * area(): method to calculate the area of a circle
     * @return the area of the circle
     */
    public double area() {
        //Area is pi times the radius squared for a circle
        return Math.PI*radius*radius;
    }
    public void setRadius(double radius) {
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
}
