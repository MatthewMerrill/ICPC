import java.util.*;

/**
 * Created by merrillm on 10/7/16.
 *
 * PacNW Regionals 2013: "Languages"
 */
public class Languages {
    public static  void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N =  Integer.parseInt(scn.nextLine());
    
        Map<String, Set<String>> keywords = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String line = scn.nextLine();
            String[] split = line.split("\\s");
            HashSet<String> set = new HashSet<>();
            for (String kw : split)
                set.add(kw);
            keywords.put(split[0], set);
        }
        
        langloop:
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            if (line.trim().isEmpty())
                continue;
            
            for (String lang : keywords.keySet()) {
                for (String keyword : keywords.get(lang)) {
                    if (line.contains(keyword)) {
                        System.out.println(lang);
                        continue langloop;
                    }
                }
            }
            
        }
        
    }
}
