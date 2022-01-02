public class BoxFractalRunnerWithoutColor {
    public static void main(String[] args) {
        double x=0.5;
        double y=0.5;
        StdDraw.setXscale(0.0,1.0);
        StdDraw.setYscale(0.0,1.0);
        double x_draw = 0;
        double y_draw =0;
        int iterations = 20000;
        for(int iter=0;iter<iterations;iter++){
            int direction = (int) ( 5*Math.random());
            if (direction == 0) {
                x_draw=(x/3.0)+ 1/3.0;
                y_draw=(y/3.0)+ 1/3.0;
            }
            if (direction == 1) {
                x_draw = x/3.0;
                y_draw = y/3.0;
            }
            if (direction == 2) {
                x_draw = (x/3.0)+ 2/3.0;
                y_draw = y/3.0;
            }
            if (direction == 3) {
                x_draw = (((1/3.0)*x)+((2/3.0)*0.0));
                y_draw = (y/3.0)+2/3.0;
            }
            if (direction ==4) {
                x_draw = (((1/3.0)*x)+((2/3.0)*1.0));
                y_draw = (((1/3.0)*y)+((2/3.0)*1.0));
            }
            StdDraw.point(x_draw,y_draw);
            x=x_draw;
            y=y_draw;

        }
    }
}
