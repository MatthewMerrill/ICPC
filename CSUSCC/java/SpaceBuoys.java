import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 14-15 Fall: "Space Buoys"
 */
public class SpaceBuoys {
    
    /*
1.32
3.75
2.61
4.83
10
     */
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        double sx  = scn.nextDouble();
        double sy  = scn.nextDouble();
        double sz  = scn.nextDouble();
        double rad = scn.nextDouble();
        
        double count = scn.nextInt();
        
        for (int i = 0; i < count; i++) {
            double dx = random();
            double dy = random() * (1 - dx * dx);
            double dz = sqrt(1 - (dx * dx + dy * dy));
            
            System.out.printf("%f %f %f\n",
                    sx + rad * dx,
                    sy + rad * dy,
                    sz + rad * dz);
        }
    }
}
