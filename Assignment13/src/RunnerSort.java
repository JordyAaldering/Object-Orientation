public class RunnerSort implements Runnable {
    private int[] array;

    RunnerSort(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        MergeSort.sort(array);
    }

    int[] get() {
        return array;
    }
}
