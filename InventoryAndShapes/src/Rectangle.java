/**
 * Rectangle is a class which uses the Shape interface, which is used to calculate the area of and create rectangle objects.
 *
 * @author Vishak Srikanth
 * @version 2/23/2021
 */
import java.lang.Math;
public class Rectangle implements Shape {
    public double height;
    public double width;

    /**
     * no-argument constructor for objects of class rectangle
     */
    public Rectangle() {
        height = 0;
        width = 0;
    }

    /**
     * constructor for objects of class rectangle
     * @param height
     * @param width
     */
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    /**
     * area(): a method to compute the area of a rectangle
     * @return the area, which is height*width
     */
    public double area() {
        return height*width;
    }
    /**
     * setHeight(): a method to set the height of a rectangle
     * @param height
     */
    public void setHeight(double height) {
        this.height=height;
    }
    /**
     * getHeight(): a method to set the height of a rectangle
     * @return height, the height of a rectangle
     */
    public double getHeight() {
        return height;
    }
    /**
     * getWidth(): a method to get the width of a rectangle
     * @return width, the width of a rectangle
     */
    public double getWidth() {
        return width;
    }
    /**
     * setWidth(): a method to set the width of a rectangle
     * @param width
     */
    public void setWidth(double width) {
        this.width=width;
    }
}
