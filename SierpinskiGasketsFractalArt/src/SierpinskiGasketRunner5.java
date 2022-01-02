public class SierpinskiGasketRunner5 {
    public static void main(String[] args) {
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 1.0;
        double y2 = 0.0;
        double x3 = 0.5;
        double y3 = Math.sqrt(3) / 2;
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x1, y1, x3, y3);
        StdDraw.line(x2, y2, x3, y3);
        SierpinskiGasket.sierpinski(3, x1, y1, x2, y2, x3, y3);
    }
}
