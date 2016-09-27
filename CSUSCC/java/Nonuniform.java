import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 12-13 Spring: "Non-uniform"
 */
public class Nonuniform {
    
    /*
2
0.5 1.0 0.25
0.0 2.0 0.1
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int cases = scn.nextInt();
        for (int casee = 0; casee < cases; casee++) {
            double Y = scn.nextDouble();
            double L = scn.nextDouble();
            double P = scn.nextDouble();
    
            Function<Double, Double> expon = (x) -> 1 - Math.pow(Math.E, -1*L*x);
            Function<Double, Double> geome  = (x) -> 1 - Math.pow(1-P,    x+1);
    
            System.out.printf("%.4f %d\n",
                    bs(expon, Y, 0, Double.MAX_VALUE),
                    (int)Math.ceil(bs(geome, Y, 0, 1000.0)-0.0001));
        }
    }
    
    private static double bs(Function<Double, Double> f, double y, double lo, double hi) {
        double x = (hi+lo)/2;
        double calculated = f.apply(x);
    
        if (hi-lo < 0.00001)
            return x;
        
        if (calculated < y)
            return bs(f, y, x, hi);
        else if (calculated > y)
            return bs(f, y, lo, x);
        else
            return x;
    }
}