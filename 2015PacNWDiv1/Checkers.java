import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by merrillm on 10/27/16.
 */
public class Checkers {
    
    public static void main(String[] rsg) {
        Scanner scn = new Scanner(System.in);
        
        int SIZE = scn.nextInt();
        int[][] board = new int[SIZE][SIZE];
        
        ArrayList<Point> blacks = new ArrayList<>();
        
        for (int r = 0; r < SIZE; r++) {
            String row = scn.next();
            for (int c = 0; c < SIZE; c++) {
                board[r][c] = row.charAt(c);
                if (board[r][c] == 'B')
                    blacks.add(new Point(r,c));
            }
        }
        
        Point pos = null;
        for (Point black : blacks) {
            if (isPossible(black, board)) {
                if (pos == null)
                    pos = black;
                else {
                    System.out.println("Multiple");
                    return;
                }
            }
        }
        
        System.out.println((pos == null) ? "None" : ((char)(pos.y+'a'))+""+(SIZE-pos.x));
    }
    
    private static boolean isPossible(Point curpos, int[][] board) {
        boolean ispossible = true;
        
        checkloop:
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == 'W') {
                    ispossible = false;
                    break checkloop;
                }
            }
        }
        
        if (ispossible)
            return true;
        
        for (Map.Entry<Point, int[][]> next : nextMoves(curpos, board).entrySet()) {
            if (isPossible(next.getKey(), next.getValue())) {
                return true;
            }
        }
        
        return false;
    }
    
    private static HashMap<Point, int[][]> nextMoves(Point curpos, int[][] board) {
        HashMap<Point, int[][]> possible = new HashMap<>();
    
        int[][] possibleMoves = new int[][]{
                {-1, -1}, {1, 1}, {-1, 1}, {1, -1}
        };
    
        for (int[] possibleMove : possibleMoves) {
            int jumpx = curpos.x + possibleMove[0];
            int jumpy = curpos.y + possibleMove[1];
            int emptyx = curpos.x + possibleMove[0] * 2;
            int emptyy = curpos.y + possibleMove[1] * 2;
            
            try {
                if (board[jumpx][jumpy] != 'W' || board[emptyx][emptyy] != '_')
                    continue;
            } catch (Exception ignored) { continue; }
                
            int[][] clone = new int[board.length][board.length];
        
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board.length; c++) {
                    clone[r][c] = board[r][c];
                }
            }
        
            clone[curpos.x][curpos.y] = '_';
            clone[jumpx][jumpy] = '_';
            clone[emptyx][emptyy] = 'B';
        
            possible.put(new Point(emptyx, emptyy), clone);
        }
        return possible;
    }
}
