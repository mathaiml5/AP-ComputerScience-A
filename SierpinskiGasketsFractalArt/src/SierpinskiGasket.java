/*
*This class has the method used to construct sierpinski gaskets.
 */
public class SierpinskiGasket {
    /*
    * sierpinski(int depth, double x_1, double y_1, double x_2, double y_2, double x_3, double y_3) draws a sierpinski
    * gaskets.
     */
 public static void sierpinski(int depth, double x_1, double y_1, double x_2, double y_2, double x_3, double y_3){
     //if depth is 0, or less don't do anything
      if(depth<=0) {
      }
      //otherwise find the midpoints of the sides of the triangle and
      else {
          double mid_12_x = (x_1 + x_2)/2 ;
          double mid_12_y = (y_1 + y_2)/2 ;
          double mid_13_x = (x_1 + x_3)/2 ;
          double mid_13_y = (y_1 + y_3)/2 ;
          double mid_23_x = (x_2 + x_3)/2 ;
          double mid_23_y = (y_2 + y_3)/2 ;
          StdDraw.line(mid_12_x,mid_12_y, mid_13_x, mid_13_y);
          StdDraw.line(mid_13_x,mid_13_y, mid_23_x, mid_23_y);
          StdDraw.line(mid_23_x,mid_23_y, mid_12_x, mid_12_y);
          sierpinski(depth-1,x_1,y_1,mid_12_x,mid_12_y,mid_13_x,mid_13_y);
          sierpinski(depth-1,x_2,y_2,mid_12_x,mid_12_y,mid_23_x,mid_23_y);
          sierpinski(depth-1,x_3,y_3,mid_13_x,mid_13_y,mid_23_x,mid_23_y);
      }
    }
}
