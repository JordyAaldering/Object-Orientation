import java.util.ArrayList;
import java.util.concurrent.locks.*;

class Buffer {
    private final Lock lock = new ReentrantLock();
    private final ArrayList<Integer> buffer;
    private int currValue;

    Buffer(int startValue) {
        buffer    = new ArrayList<>();
        currValue = startValue;
    }

    void increment() {
        lock.lock();
        buffer.add(currValue);
        currValue++;
        lock.unlock();
    }

    void remove(int index) {
        lock.lock();
        buffer.remove(index);
        lock.unlock();
    }

    int size() {
        lock.lock();
        int size = buffer.size();
        lock.unlock();
        return size;
    }

    int get(int index) {
        lock.lock();
        int value = buffer.get(index);
        lock.unlock();
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("First 100 primes:\n");
        for (int i = 0; i < size() && i < 100; i++) {
            sb.append(i+1).append(": ").append(buffer.get(i)).append("\n");
        }
        return sb.toString();
    }
}
