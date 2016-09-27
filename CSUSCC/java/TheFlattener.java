import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 14-15 Fall: "The Flattener"
 */
public class TheFlattener {
    
    /*
4
f
(f3)
(abc5)
(abc(DE2)f3)
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        
        for (int i = 0; i < N; i++) {
            String in = scn.next();
            System.out.printf("%s\n=%s\n",
                    in,
                    /*=*/flatten(in));
        }
    }
    
    private static String flatten(String str) {
        while (true) {
            /* https://xkcd.com/1171/ */
            Pattern pattern = Pattern.compile(".*(\\(([a-zA-Z]+)([1-9])\\)).*");
            Matcher matcher = pattern.matcher(str);
            
            if (!matcher.matches())
                return str;
            
            str = str.replace(matcher.group(1), rep(matcher.group(2), Integer.valueOf(matcher.group(3))));
        }
    }
    
    private static String rep(String str, int count) {
        return Stream.generate(()->str).limit(count).collect(joining());
    }
}