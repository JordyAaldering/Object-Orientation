import java.util.concurrent.locks.*;

class Sieve implements Runnable {
    private final Lock lock = new ReentrantLock();
    private final Buffer buffer;
    private int index;

    Sieve(Buffer buffer) {
        this.buffer = buffer;
        this.index  = 0;
    }

    @Override
    public void run() {
        lock.lock();
        int value = buffer.get(index), i = index+1;

        while (i < buffer.size()) {
            if (buffer.get(i) % value == 0) {
                buffer.remove(i);
            }
            i++;
        }
        index++;
        lock.unlock();
    }
}
