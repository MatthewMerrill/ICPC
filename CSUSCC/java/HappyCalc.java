import java.util.Scanner;

/**
 * Created by merrillm on 9/26/16.
 *
 * CSUS 12-13 Spring: "Happy Calc"
 */
public class HappyCalc {
    
    /*
3
1000 2000
123 321
11 12

>>
3000
Unlucky! Unlucky!
Unlucky! Unlucky!
    */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int N = scn.nextInt();
        
        for (int n = 0; n < N; n++) {
            System.out.printf("%s", happyCalc(scn.nextInt(), scn.nextInt()));
        }
    }
    
    public static final String UNLUCKY = "Unlucky! Unlucky!";
    public static String happyCalc(int a, int b) {
        if (isPalindrome(a+"") || isPalindrome(b+""))
            return UNLUCKY;
        
        int res = a + b;
        
        return isPalindrome(res+"") ? UNLUCKY : (res + "");
    }
    
    public static boolean isPalindrome(String text) {
        int len = text.length();
        for (int i = 0; i < len / 2; i++) {
            if (text.charAt(i) != text.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}
