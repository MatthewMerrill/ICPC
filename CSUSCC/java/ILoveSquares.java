import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 12-13 Spring: "I Love Squares"
 */
public class ILoveSquares {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        
        int N = scn.nextInt();
        int spacing = scn.nextInt();
        
        list.add("*");
        
        for (int i = 1; i < N; i++) {
            
            for (int j = 0; j < list.size(); j++) {
                list.set(j,
                        '*' + rep(' ', spacing) +
                                list.get(j) +
                                rep(' ', spacing) + '*');
            }
    
            for (int j = 0; j < spacing; j++)
                list.add(0, '*' + rep(' ', list.get(0).length()-2)+ '*');
            
            list.add(0, rep('*', list.get(0).length()));
    
            for (int j = 0; j < spacing; j++)
                list.add('*' + rep(' ', list.get(0).length()-2)+ '*');
            
            list.add(rep('*', list.get(0).length()));
        }
        
        System.out.println(list.stream().collect(Collectors.joining("\n")));
    }
    
    public static String rep(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append(ch);
        return sb.toString();
    }
}
