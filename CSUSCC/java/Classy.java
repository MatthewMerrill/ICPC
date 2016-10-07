import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by merrillm on 10/7/16.
 *
 * PacNW Regionals 15-16: "Classy"
 */
public class Classy {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = Integer.valueOf(scn.nextLine());
        
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scn.nextLine().split(":?\\s"));
        }
        
        list.sort((a,b)->{
            for (int i = 0; i < max(a.length,b.length)-1; i++) {
                int cmp = ((i>a.length-2)?"middle":a[a.length-i-1])
                        .compareTo(
                                ((i>b.length-2)?"middle":b[b.length-i-1]));
                if (cmp != 0)
                    return -1*cmp;
            }
            return a[0].compareTo(b[0]);
        });
        
        list.forEach(l -> System.out.println(l[0]));
    }
}
