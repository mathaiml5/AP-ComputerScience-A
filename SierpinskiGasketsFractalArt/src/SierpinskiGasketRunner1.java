import java.lang.*;
public class SierpinskiGasketRunner1 {
    public static void main(String[] args) {
        double x1 = Math.random();
        double y1 = Math.random();
        double x2 = Math.random();
        double y2 = Math.random();
        double x3 = Math.random();
        double y3 = Math.random();
        StdDraw.line(x1,y1,x2,y2);
        StdDraw.line(x1,y1,x3,y3);
        StdDraw.line(x2,y2,x3,y3);
        SierpinskiGasket.sierpinski(3,x1,y1,x2,y2,x3,y3);
    }
}
