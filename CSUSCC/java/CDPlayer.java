import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by merrillm on 10/7/16.
 *
 * CSUS 15-16 Spring: "CD Player"
 */
public class CDPlayer {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int D = scn.nextInt() +1;
        int[][] discs = new int[D][];
        int[] discHits = new int[D];
        
        discs[0] = new int[1];
        for (int d = 1; d < D; d++) {
            discs[d] = new int[scn.nextInt() + 1];
        }
        
        int maxDisc = 0, maxTrack = 0, maxDiscHit = 0;
        while (scn.hasNext()) {
            int d = scn.nextInt();
            int t = scn.nextInt();
            discs[d][t]++;
            discHits[d]++;
            if (discs[d][t] > discs[maxDisc][maxTrack]) {
                maxDisc = d;
                maxTrack = t;
            }
            if (discHits[d] > discHits[maxDiscHit])
                maxDiscHit = d;
        }
    
        for (int d = 0; d < discs.length; d++) {
            int[] disc = discs[d];
            StringJoiner sj = new StringJoiner(", ");
            for (int t = 0; t < disc.length; t++)
                if (discs[d][t] > 0)
                    sj.add(t+"");
            if (sj.length() > 0)
                System.out.printf("Disc %d: Tracks %s\n", d, sj.toString());
        }
        System.out.printf("The most used disc was number %d\n", maxDiscHit);
        System.out.printf("The most used track was number %d of disc %d\n", maxTrack, maxDisc);
    }
}