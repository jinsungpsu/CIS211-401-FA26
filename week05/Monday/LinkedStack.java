public class LinkedStack<T> implements Stack<T> {
    private Node top;
    private int count;

    @Override
    public void push(T value) throws IllegalStateException {
        // should look a lot like
        // addFront from the lecture examples
        // because we are makin the design choice
        // for top of stack = head of linked list
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T pop() {
        // special case... make sure empty stack gets handled...
        Node temp = top; // prevents the top (that I'm trying to remove from becoming orphaned)
        top = top.next;
        count--;
        return temp.data;
    }

    class Node {
        T data;
        Node next;
    }
}
