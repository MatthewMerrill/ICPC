import java.util.*;

/**
 * Created by merrillm on 10/7/16.
 *
 * PacNW Regionals 2013: "Enterprising Escape"
 */
public class EnterprisingEscape {
    
    static class Node {
        
        int row;
        int col;
        Integer cost;
        Integer running = -1;
        
        Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    
    public static void main(String[] arg) {
        Scanner scn = new Scanner(System.in);
        
        int T = scn.nextInt();
        
        caseloop:
        for (int _t = 0; _t < T; _t++) {
            int k = scn.nextInt(), w = scn.nextInt(), h = scn.nextInt();
            
            Node[][] grid = new Node[h][w];
            
            int er = 0, ec = 0;
            
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < k; i++) {
                map.put(scn.next(), scn.nextInt());
            }
            
            for (int r = 0; r < h; r++) {
                grid[r] = new Node[w];
                
                String[] line = scn.next().split("");
                for (int c = 0; c < w; c++) {
                    String val = line[c];
                    
                    if (val.equals("E")) {
                        er = r;
                        ec = c;
                        Node e = new Node(r,c,0);
                        e.running = 0;
                        grid[r][c] = e;
                        continue;
                    }
                    
                    grid[r][c] = new Node(r,c,map.get(val));
                }
            }
            
            // A* Search
            
            List<Node> list = new ArrayList<>();
            list.add(grid[er][ec]);
            
            while (!list.isEmpty()) {
    
                list.sort((a,b) ->
                        a.running.compareTo(b.running));
                
                Node n = list.remove(0);
            
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (Math.abs(dr) + Math.abs(dc) != 1)
                            continue;
                        
                        if (n.row + dr < 0 || n.row + dr >= h || n.col + dc < 0 || n.col + dc >= w) {
                            System.out.println(n.running);
                            continue caseloop;
                        }
                        
                        Node o = grid[n.row + dr][n.col + dc];
                        if (o.running == -1 || n.running + o.cost < o.running) {
                            list.add(o);
                            o.running = n.running + o.cost;
                        }
                    }
                }
            }
        }
    }
}
