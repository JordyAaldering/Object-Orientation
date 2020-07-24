import java.util.concurrent.ThreadLocalRandom;

class Utils {
    static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
