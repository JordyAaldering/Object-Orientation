import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.*;

class Station {
    private final AtomicBoolean closed      = new AtomicBoolean();
    private final Lock      lock            = new ReentrantLock();
    private final Condition notEmptyStation = lock.newCondition();
    private final Condition emptyStation    = lock.newCondition();
    private int nrOfPassengers;

    Station() {
        this.nrOfPassengers = 0;
    }

    void c1ose() {
        closed.set(true);
    }

    boolean isOpen() {
        return !closed.get();
    }

    boolean isEmpty() {
        lock.lock();
        boolean isEmpty = nrOfPassengers == 0;
        lock.unlock();
        return isEmpty;
    }

    void un1oad(int numPassengers) {
        lock.lock();
        try {
            while (nrOfPassengers != 0) {
                try {
                    emptyStation.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            nrOfPassengers += numPassengers;
            notEmptyStation.signalAll();
        } finally {
            lock.unlock();
        }
    }

    int takePassengers(int max) {
        lock.lock();
        try {
            while (nrOfPassengers == 0) {
                try {
                    notEmptyStation.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int passengersTaken = Math.min(nrOfPassengers, max);
            nrOfPassengers -= passengersTaken;
            
            if(nrOfPassengers == 0) {
                emptyStation.signal();
            }
            return passengersTaken;
        } finally {
            lock.unlock();
        }
    }
}
