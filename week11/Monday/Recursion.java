import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        countup(0);
    }

    static void countup(int num) {
        System.out.println(num);
        countup(++num);
    }

    int factorial(int n) {
        if (n == 0) return 1;
        int x = factorial(n - 1);

        return n * x;
    }

    static void countdown(int num) {
        if(num < 0) {
            return;
        }
        System.out.printf("%d ", num);
        countdown(num-1);
        return;
    }

    static boolean binarySearch(int[] arr, int low, int high, int target) {
        int index = high-low / 2;
        if (arr[index] == target){
            // found it!
            // BASE CASE!!!!
        } else {
            // recursive call
            // is it in left or right?
            if (target < arr[index]) {
                // left side
                return binarySearch(arr, low, index-1, target);
            } else {
                // more code
            }
        }
        return false; // couldn't find it
        // some debugging needed... I'm pretty sure there's a couple of small boundary errors
    }

}
