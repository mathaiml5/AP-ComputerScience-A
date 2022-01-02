import java.lang.Math;
public class SierpinskiCarpet {
    public static void BoxFractal(double x, double y, int iter) {
        if (iter <= 0) {
        }
        else {
            double x_draw;
            double y_draw;
            int direction = (int) (5 * Math.random());
            if (direction == 0) {
                x_draw = ((x/3)+((2/3)*0.5));
                y_draw = ((y/3)+((2/3)*0.5));
            }
            if (direction == 1) {
                x_draw = (x/3);
                y_draw = (y/3);
            }
            if (direction == 2) {
                x_draw = (((1/3)*x)+((2/3)*1.0));
                y_draw = (((1/3)*y)+((2/3)*0.0));
            }
            if (direction == 3) {
                x_draw = (((1/3)*x)+((2/3)*0.0));
                y_draw = (((1/3)*y)+((2/3)*1.0));
            }
            else {
                x_draw = (((1/3)*x)+((2/3)*1.0));
                y_draw = (((1/3)*y)+((2/3)*1.0));
            }
            StdDraw.line(x,y,x_draw,y_draw);
            BoxFractal(x_draw,y_draw,iter-1);
         }
    }
}
