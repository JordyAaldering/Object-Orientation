import java.io.*;
import java.util.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Main {
    private static int[] array;

    /**
     *  AVAILABLE PROCESSORS: 8
     * TIME IN MS FOR PART 2: 982ms
     * TIME IN MS FOR PART 1: 5ms
     */
    public static void main(String[] args) {
        System.out.println("AVAILABLE PROCESSORS: "+Runtime.getRuntime().availableProcessors());
        makeArray();

        long start = System.currentTimeMillis();
        mergeSortTest();
        long time = System.currentTimeMillis()-start;
        System.out.println("TIME IN MS FOR PART 2: "+time+"ms");

        start = System.currentTimeMillis();
        fileFinderTest();
        time = System.currentTimeMillis()-start;
        System.out.println("TIME IN MS FOR PART 1: "+time+"ms");


    }

    private static void fileFinderTest() {
        try {
            String goal = "FileFinder.java";
            String root = "C:\\Users\\Aalde\\Documents";
            FileFinder ff = new FileFinder(root);
            ff.findFile(goal);
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    private static void mergeSortTest() {
        MergeSort.sort(array);
        // System.out.println("Sorted: "+MergeSort.isSorted(array));
    }

    private static void makeArray() {
        int SIZE = 10000000;
        array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }
    }
}
