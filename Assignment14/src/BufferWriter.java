public class BufferWriter implements Runnable {
    private final Buffer buffer;
    private final int start, end;

    BufferWriter(Buffer buffer, int start, int end) {
        this.buffer = buffer;
        this.start  = start;
        this.end    = end;
    }

    @Override
    public void run() {
        for (int i = 0; i < end; i++ ) {
            buffer.put(start+i);
        }
    }
}
