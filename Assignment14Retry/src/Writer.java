class Writer implements Runnable {
    private final Buffer buffer;
    private final int    size;

    Writer(Buffer buffer, int size) {
        this.buffer = buffer;
        this.size   = size;
    }

    @Override
    public void run() {
        while (buffer.size() < size) {
            buffer.increment();
        }
    }
}
