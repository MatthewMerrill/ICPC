import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by merrillm on 10/27/16.
 */
public class Airports {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int N = scn.nextInt();
        int M = scn.nextInt();
        
        int[] p = IntStream.generate(scn::nextInt).limit(N).toArray();
        int[][] t = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                t[i][j] = scn.nextInt();
            }
        }
    
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < M ; i++) {
            int s = scn.nextInt()-1;
            int f = scn.nextInt()-1;
            int startTime = scn.nextInt();
            int finishTime = startTime + t[s][f] + p[f];
            list.add(startTime);
            list.add(-finishTime);
        }
        
        list.sort((a,b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        
        int count = 0;
        int maxcount = 0;
        
        for (Integer i : list) {
            count += i / Math.abs(i);
            if (count > maxcount)
                maxcount = count;
        }
        
        System.out.printf("%d\n", maxcount);
    }
}