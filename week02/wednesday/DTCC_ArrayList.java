import java.util.ArrayList;
import java.util.Arrays;

public class DTCC_ArrayList {
    // can only hold integers...
    // required methods
    // ** add
    // *** param: int value
    // ** get
    // *** param: int index
    // ** toString

    // if you want to practice more...
    // try remove
    // ** param: int index

    private int[] stuff; // this is just a ref var
    private int count;

    public DTCC_ArrayList() {
        // no arg constructor
        // this DEFAULT SIZE of 5
        stuff = new int[5];
    }

    public DTCC_ArrayList(int size) {
        stuff = new int[size];
    }

    public void add(int value) {
        /*
        todo: don't always write to index 0
        what to do when capacity is reached!
         */
        if (count == stuff.length) {
            // array is full!  can't add
            System.out.println("Ahhhh");
            return;
        }

        // next section of code adds the item into the list
        stuff[count] = value;
        count++;
    }

    public int get(int index) {
        /*
        todo: check if index is within bounds
        if it's not, create a new exception and throw it!!!

         */
        if (index == -1) {
            throw new IndexOutOfBoundsException("The index you provide of -1 doesn't make sense.");
        }

        return 0;
    }

    /*
    toString method WILL BE ON THE EXAM!!!
     */

    @Override
    public String toString() {
        if (count == 0) {
            // the list is empty
            return "[]";
        }
        else {
            String output = "[";
            output += "start adding stuff";
            output += "maybe go through a for loop and add the elements into this string";
            // there's some stuff here...
            // I'll need a for loop probably

            output += "]";
            return output;
        }

    }

    public String toString2() {
        if (count ==0) return "[]";
        else {
            StringBuilder output = new StringBuilder();
            output.append("[");

            // do some stuff

            output.append("]");
            return output.toString();
        }
    }
}

class Tester {
    public static void main(String[] args) {
        DTCC_ArrayList mylist = new DTCC_ArrayList(); // <-- THE ARRAY IS SIZE 5
        //DTCC_ArrayList mylist2 = new DTCC_ArrayList(500); // <-- THE ARRAY IS SIZE 500

        mylist.add(10);
        mylist.add(20);
        mylist.add(30);
        System.out.println("In index 2, value is: " + mylist.get(2));
        mylist.add(40);
        mylist.add(50);

        System.out.println(mylist); // TOSTRING

        /*
        java.util.ArrayList
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }

        System.out.println(list);
    }
}
