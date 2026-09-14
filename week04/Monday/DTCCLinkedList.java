import javax.xml.stream.events.DTD;

public class DTCCLinkedList {
    private Node head;
    private int count;;

    public DTCCLinkedList() {
        head = null;
        count = 0;
        // both of these thing would have happened
        // if i didn't have a default constructor
        // because in java
        // primitive types get initialized with 0 (or false for boolean)
        // ref types get initialized with null
    }

    public void add(int value) {
        // this only works if the list is empty...
        Node node = new Node();
        node.data = value;
        count++;
        head = node;

        // we need to add some code in here, so that the new node
        // being created gets linked to the existing items

    }

    public int get(int i) {
        return 0;
    }

}
class Node {
    int data;
    Node next;
}

class LinkedListLabDriver {
    public static void main(String[] args) {
        DTCCLinkedList list = new DTCCLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Element at index 1: " + list.get(1)); // Output: 20
        System.out.println("List: " + list.toString()); // Output: [10, 20, 30]

        list.add(40);
        list.add(50);

        System.out.println("List after adding more elements: " + list.toString()); // Output: [10, 20, 30, 40, 50]
    }
}
