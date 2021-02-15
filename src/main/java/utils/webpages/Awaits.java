package utils.webpages;

import org.awaitility.core.ThrowingRunnable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.given;

public class Awaits {

    static int timeout = Integer.parseInt(System.getProperty("defaultTimeout"));

    public static void waitForConditionFulfilled(ThrowingRunnable callable) {
        given().ignoreExceptions().with()
                .timeout(timeout, SECONDS)
                .and().with()
                .pollInterval(2, SECONDS)
                .await()
                .untilAsserted(callable);
    }
}
