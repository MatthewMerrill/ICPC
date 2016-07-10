import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.*;

/**
 * Created by merrillm on 7/10/16.
 */
public class TestIO {

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(in);




    }

    static class TestSum {

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int[] arr = IntStream
                    .generate(scn::nextInt)
                    .limit(scn.nextInt())
                    .toArray();

            System.out.println(Arrays.stream(arr).sum());
        }

    }
}
