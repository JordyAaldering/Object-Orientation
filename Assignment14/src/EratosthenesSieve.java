public class EratosthenesSieve implements Runnable {
    private final Buffer buffer;

    EratosthenesSieve(Buffer buffer) {
        this.buffer = buffer;
    }

    private void removeMultiples(int start) {
        int value = buffer.get(start);
        for (int i = start+1; i < buffer.size();) {
            if (buffer.get(i) % value == 0) {
                buffer.remove(i);
            } else {
                i++;
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < buffer.size(); i++) {
            removeMultiples(i);
        }
    }
}
