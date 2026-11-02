import java.util.Arrays;
import java.util.Random;

public class Main {

    // Easy-to-change constants
    static final int METHODS = 2;          // Arrays.sort vs yourOwnSort
    static final int TRIALS = 10;          // Number of trials
    static final int ARRAY_SIZE = 50000;   // Size of each array

    public static void main(String[] args) {

        Random rand = new Random();

        // 2 x 10 x 50000
        int[][][] testData = new int[METHODS][TRIALS][ARRAY_SIZE];

        // Fill all arrays with random integers
        for (int method = 0; method < METHODS; method++) {
            for (int trial = 0; trial < TRIALS; trial++) {
                for (int i = 0; i < ARRAY_SIZE; i++) {
                    testData[method][trial][i] = rand.nextInt(100000);
                }
            }
        }

        long[][] times = new long[TRIALS][METHODS];
        // [trial][method]

        for (int trial = 0; trial < TRIALS; trial++) {
            for (int position = 0; position < METHODS; position++) {

                int method = (trial + position) % METHODS;

                // Clone so sorting doesn't modify original data
                int[] array = testData[method][trial].clone();

                long start = System.nanoTime();

                if (method == 0) {
                    arraysSort(array);
                } else {
                    yourOwnSort(array);
                }

                long elapsed = System.nanoTime() - start;
                times[trial][method] = elapsed;
            }
        }

        System.out.println("Trial\tArrays.sort\tYour Sort");
        for (int trial = 0; trial < TRIALS; trial++) {
            System.out.printf(
                    "%2d\t%,12d\t%,12d%n",
                    trial + 1,
                    times[trial][0],
                    times[trial][1]
            );
        }
    }

    static void arraysSort(int[] arr) {
        Arrays.sort(arr);
    }

    static void yourOwnSort(int[] arr) {
        // Replace with your own sorting algorithm

        for (int i = 0; i < 50000; i++) {
            System.out.println("Working really hard...");
        }
    }
}
