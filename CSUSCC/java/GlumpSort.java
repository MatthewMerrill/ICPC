import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by merrillm on 10/7/16.
 *
 * CSUS 14-15 Fall: "Glump Sort"
 */
public class GlumpSort {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String next;
        
        while (!(next = scn.next()).equals("1000"))
            list.add(next);
    
        Map<String, Long> premap = list.stream().collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
        
        Map<String, Long> map = new HashMap<>();
        for (String s : list) {
            Long val = premap.get(rev(s));
            map.put(s, val == null ? 0 : val);
        }
        
        list.sort((a, b) -> {
            int countcmp = map.get(b).compareTo(map.get(a));
            if (countcmp != 0) {
                return countcmp;
            } else {
                return 0;
            }
        });
        
        list.forEach(System.out::println);
    }
    
    static String rev(String str) {
        return new BigInteger(new StringBuffer(str).reverse().toString()).toString();
    }
}
