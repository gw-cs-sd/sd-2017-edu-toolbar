package tutorial;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static int generateRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
