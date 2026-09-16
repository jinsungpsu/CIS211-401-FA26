public class DTCCLinkedList {
    private Node head;
    private int count;

    public DTCCLinkedList() {
        head = null;
        count = 0;
        // both of these thing would have happened
        // if i didn't have a default constructor
        // because in java
        // primitive types get initialized with 0 (or false for boolean)
        // ref types get initialized with null
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.data = value;
        node.next = head;

        head = node;
        count++;

    }

    public void add(int value) {
        Node node = new Node();
        node.data = value;

        // this happens whether I explicitly write it or not
        node.next = null;

        if (count == 0) {
            // this only works if the list is empty...
            head = node;
        } else {
            Node itr = head;

            while (itr.next != null) {
                itr = itr.next;
            }

            itr.next = node;
        }
        count++;

        // we need to add some code in here, so that the new node
        // being created gets linked to the existing items

    }

    public int get(int i) {
        return 0;
    }
    private class Node {
        int data;
        Node next;
    }

}

class LinkedListLabDriver {
    public static void main(String[] args) {

        DTCCLinkedList list = new DTCCLinkedList();

        // testing add front
        list.addFirst(-10);
        list.addFirst(-20);
        list.addFirst(-30);

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Element at index 1: " + list.get(1)); // Output: 20
        System.out.println("List: " + list.toString()); // Output: [10, 20, 30]

        list.add(40);
        list.add(50);

        System.out.println("List after adding more elements: " + list.toString()); // Output: [10, 20, 30, 40, 50]

        int[] nums = {10,20,30};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        /*
        i++;
        i = i + 1;
         */
    }
}
