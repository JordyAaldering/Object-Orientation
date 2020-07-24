import java.util.ArrayList;

public class Buffer {
    private final ArrayList<Integer> buffer;

    Buffer() {
        this.buffer = new ArrayList<>();
    }

    void put(int value) {
        assert value >= 2;
        buffer.add(value);
    }

    void remove(int index) {
        assert index >= 0 && index < buffer.size();
        buffer.remove(index);
    }

    int size() {
        return buffer.size();
    }

    int get(int index) {
        assert index >= 0 && index < buffer.size();
        return buffer.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(i+1).append(": ").append(buffer.get(i)).append("\n");
        }
        return sb.toString();
    }
}
