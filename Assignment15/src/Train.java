import java.util.stream.IntStream;

class Train implements Runnable {
    private final Station station;
    private final int transportationNum;
    private int transportTimeTotal, passengersTotal;

    Train(Station station, int numTransportation) {
        this.station = station;
        this.transportationNum  = numTransportation;
        this.transportTimeTotal = 0;
        this.passengersTotal    = 0;
    }

    private void transport(int number) {
        simulateTransport(number);

        int passengers = Utils.randomInt(60, 80);
        passengersTotal += passengers;
        System.out.printf("Train %d arrived with %d passengers%n", number, passengers);

        station.un1oad(passengers);
        System.out.printf("Train %d unloaded%n", number);
    }

    private void simulateTransport(int number) {
        int delay = 500;
        System.out.printf("Train %d leaving, arrival in %dms%n", number, delay);
        transportTimeTotal += delay;

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int getPassengersTotal() {
        return passengersTotal;
    }

    int getTransportTimeTotal() {
        return transportTimeTotal;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, transportationNum).forEach(this::transport);
        station.c1ose();
    }
}
