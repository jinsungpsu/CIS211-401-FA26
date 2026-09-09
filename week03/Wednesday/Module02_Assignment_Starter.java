/*
My name
I will use AI responsibly
 */
public class Module02_Assignment {
    public static void main(String[] args) {
        // a bunch of code here to test the ArrayStack object

        Stack<Integer> mystack = new ArrayStack<>();
        mystack.push(50);
    }
}

class ArrayStack<T> implements Stack<T> {
    // a bunch of code here...
}

// you need to use the provided interface
// do NOT make any changes here

/*
 * @author Delaware Technical Community College
 * Starter and/or reference code provided for Delaware Technical Community College courses.
 *
 * Stack ADT
 */
interface Stack<T> {

    /**
     * Adds a new entry to the top of the stack.
     *
     * @param item An object to be added to the stack.
     * @throws IllegalStateException if the element cannot be added due to capacity restrictions.
     */
    void push(T item) throws IllegalStateException;

    /**
     * Removes and returns the top entry of the stack.
     *
     * @return The object at the top of the stack, or null if the stack is empty.
     */
    T pop();

    /**
     * Retrieves the top entry of the stack without removing it.
     *
     * @return The object at the top of the stack, or null if the stack is empty.
     */
    T peek();

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Retrieves the number of entries in the stack.
     *
     * @return The number of entries.
     */
    int length();
}
