class Taxi implements Runnable {
    private final Station station;  
    private final int capacity, taxiNr;
    private int transportTimeTotal, passengersTotal;

    Taxi(Station station, int capacity, int number) {
        this.station  = station;
        this.capacity = capacity;
        this.taxiNr   = number;
        this.transportTimeTotal = 0;
        this.passengersTotal    = 0;
    }

    private int takePassengers() {
        return station.takePassengers(capacity);
    }

    private void transport() {
        int passengers   = takePassengers();
        passengersTotal += passengers;

        System.out.printf("Taxi %d picked up %d passengers%n", taxiNr, passengers);
        simulateTransport();
    }

    private void simulateTransport() {
        int delay = 250;
        transportTimeTotal += delay;
        System.out.printf("Taxi %d leaving, returns in %dms%n", taxiNr, delay);

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
        while(station.isOpen() || !station.isEmpty()) {
            transport();
        }
    }
}
