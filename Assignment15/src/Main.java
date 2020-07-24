import java.util.*;
import java.util.concurrent.*;

/**
 * @author Jordy Aaldering,     s1004292
 * @author Thomas van Harskamp, s1007576
 */
class Main {
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final Station station  = new Station();
    private static final Train   train    = new Train(station, 10);
    private static List<Taxi> taxis;

    public static void main(String[] args) {
        makeTaxis();
        execute();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        statistics();
    }

    private static void makeTaxis() {
        taxis = Arrays.asList(
                new Taxi(station, 7, 1),
                new Taxi(station, 7, 2),
                new Taxi(station, 5, 3),
                new Taxi(station, 5, 3));
    }

    private static void execute() {
        for (Taxi taxi : taxis) {
            executor.submit(taxi);
        }

        executor.submit(train);
        executor.shutdown();
    }

    private static void statistics() {
        System.out.printf("%nAll persons have been transported%n");
        System.out.printf("Train transport time in total: %d%n", train.getTransportTimeTotal());
        System.out.printf("Train passengers in total: %d%n",     train.getPassengersTotal());
        System.out.printf("Taxi transport time in total: %d%n",  taxis.stream().map(Taxi::getTransportTimeTotal).reduce(0, Integer::sum));
        System.out.printf("Taxi passengers in total: %d%n",      taxis.stream().map(Taxi::getPassengersTotal).reduce( 0, Integer::sum));
    }
}
