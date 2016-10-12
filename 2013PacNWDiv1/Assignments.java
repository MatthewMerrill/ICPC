import java.util.Scanner;

/**
 * Created by merrillm on 10/7/16.
 *
 * PacNW Regionals 2013: "Assignments"
 */
public class Assignments {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        
        for (int _T = 0; _T < T; _T++) {
            long N = scn.nextInt(), D = scn.nextInt();
            
            int count = 0;
            
            
            for (int n = 0; n < N; n++) {
                
                long v = scn.nextInt();
                long f = scn.nextInt();
                long c = scn.nextInt();
                
                double time = D * 1.0 / v;
                double maxtime = f * 1.0 / c;
                
               // System.out.printf("%f,%f\n", time, maxtime);
                
                if (f * v >= D * c)
                    count++;
            }
            
            System.out.println(count);
        }
    }
}
