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
        stuff[0] = value;
        count++;
    }

    public int get(int index) {
        return 0;
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

    }
}
