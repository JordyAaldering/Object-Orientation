import java.util.*;

class MergeSort {
    /**
     * Sort the given array in O(N log N) time.
     * The array is split in two parts of equal size.
     * These parts are sorted recursively and merged.
     */
    static void sort(int[] array) {
        if (array.length > 1) {
            int[] firstHalf = Arrays.copyOf(array, array.length / 2);
            int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

            if (array.length < 10000) {
                sort(firstHalf);
                sort(secondHalf);
                merge(firstHalf, secondHalf, array);
            } else {
                RunnerSort r1 = new RunnerSort(firstHalf), r2 = new RunnerSort(secondHalf);
                Thread t1 = new Thread(r1), t2 = new Thread(r2);
                t1.start();
                t2.start();

                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                merge(r1.get(), r2.get(), array);
            }
        }
    }

    /**
     * Merge two sorted arrays: O(N).
     * @param part1 a sorted array
     * @param part2 a sorted array
     * @param dest  destination, length must be >= part1.length + part2.length
     */
    private static void merge(int[] part1, int[] part2, int[] dest) {
        int part1Index = 0, part2Index = 0, destIndex = 0;
        while (part1Index < part1.length && part2Index < part2.length) {
            if (part1[part1Index] < part2[part2Index]) {
                dest[destIndex++] = part1[part1Index++];
            } else {
                dest[destIndex++] = part2[part2Index++];
            }
        }
        while (part1Index < part1.length) {
            dest[destIndex++] = part1[part1Index++];
        }
        while (part2Index < part2.length) {
            dest[destIndex++] = part2[part2Index++];
        }
    }

    /**
     * Simple  check to see if array is nondecreasing.
     * @return array is sorted
     */
    static boolean isSorted(int[] array) {
        int current = array[0];
        for (int i: array) {
            if (i < current) {
                return false;
            } else {
                current = i;
            }
        }
        return true;
    }
}