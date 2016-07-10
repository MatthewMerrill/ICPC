import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;

/**
 * Created by merrillm on 7/10/16.
 */
public class TestRunner {

    enum TestResult {
        RUNTIME_EXCEPTION,
        COMPILE_ERROR,
        TIME_LIMIT_EXCEEDED,
        NO_MAIN_FOUND,

        WRONG_ANSWER,
        CORRECT_ANSWER
    }

    @Test
    public void TestIO() {
        assertEquals(TestResult.CORRECT_ANSWER,
                test(TestIO.class,
                        "Hello World?", "Hello", 5));
    }

    @Test
    public void TestSum() {
        assertEquals(TestResult.CORRECT_ANSWER,
                test(TestIO.TestSum.class,
                        "4\n1 2 3 4", "10", 5));
    }

    public TestResult test(Class clazz, String input, String output, int allowedTime) {

        PrintStream stdout = System.out;
        InputStream stdin = System.in;
        try {
            Method main = clazz.getMethod("main", String[].class);

            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(out));
            AtomicBoolean errorThrown = new AtomicBoolean(false);

            CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(
                    () -> {
                        try {
                            main.invoke(null, (Object)new String[0]);
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            errorThrown.set(true);
                            return false;
                        }
                    });

            try {
                if (!future.get(allowedTime, TimeUnit.SECONDS)) {
                    return TestResult.RUNTIME_EXCEPTION;
                }
            } catch (TimeoutException e) {
                return TestResult.TIME_LIMIT_EXCEEDED;
            }

            // TODO: Wrong answer checking?
            return TestResult.CORRECT_ANSWER;

            //String result = out.toString();
        } catch (NoSuchMethodException e) {
            return TestResult.NO_MAIN_FOUND;
        } catch (Exception e) {
            e.printStackTrace();
            return TestResult.COMPILE_ERROR;
        } finally {
            System.setOut(stdout);
            System.setIn(stdin);
        }
    }

}
