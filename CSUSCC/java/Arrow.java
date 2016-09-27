import java.util.Scanner;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 14-15 Spring: "Arrow"
 */
public class Arrow {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        double speed = scn.nextDouble();
        double X0 = scn.nextDouble();
        double Y0 = -1 * scn.nextDouble();
        
        /*
        Vy = V0 sin( th )
        Y = -9.8 t ^ 2 + V0 sin( th ) t + Y0
        X = V0 cos( th ) t + X0
        
        t = (X0) / (V0 cos( th ))
        X = V0 cos( th ) (Y  - Y0) / (V0 sin(th)) + X0
         */
        
        double closestTheta = -1;
        double closestDistance = Double.MAX_VALUE;
        for (double theta = 0; theta <= 45; theta += 0.001) {
            double y = y(theta, speed, X0, Y0);
            
            if (y < -0.00001) {
                continue;
            }
            
            if (Math.abs(y) < Math.abs(closestDistance)) {
                //System.out.println(y + " is closer than " + closestDistance);
                closestDistance = y;
                closestTheta = theta;
            }
        }
        
        System.out.println(closestDistance > 0.001 ? "None" : closestTheta);
    }
    
    public static double y(double theta, double V0, double X0, double Y0) {
        double time = X0 / (V0 * cos(theta));
        return Y0  +  V0*sin(theta)*time  +  (-4.9)*time*time;
    }
    
}
