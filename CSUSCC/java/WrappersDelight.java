import java.util.Scanner;
import java.util.StringJoiner;

import static java.lang.System.in;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 15-16 F3: "Wrapper's Delight"
 */
public class WrappersDelight {
    
    /*
8 20
I said a hip hop, Hippie
to the hippie, The hip,
hip a hop, and you don't
stop, a rock it To the
bang bang boogie, say, up
jump the boogie, To the
rhythm of the boogie, the
beat.
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(in);
        scn.nextInt(); // garbage
        
        String buff = "";
        int wrapCount = scn.nextInt();
        
        StringJoiner sj = new StringJoiner("\n");
        while (scn.hasNext()) {
            String tok = scn.next();
            
            if (tok.length() > wrapCount) {
                System.out.println("error");
                return;
            }
            
            if ((buff+tok).length() > wrapCount) {
                sj.add(buff.trim());
                buff = "";
            }
            
            buff += tok + " ";
        }
        sj.add(buff);
        
        System.out.println(sj);
    }
}
