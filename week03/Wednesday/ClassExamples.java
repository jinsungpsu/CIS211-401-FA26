interface Stack<T> {
    /*
    This method adds the @param value to the top of this stack
    If the implementing class cannot add it, it should throw
    an @exception IllegalStateException
     */
    public void push(T value) throws IllegalStateException;

    /*
    great documentation goes here
     */
    public T peek();

    /*
    some more great doc
     */
    public T pop();
}

class Digimon {
    private String name;

    public Digimon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Digimon {" +
                "name='" + name + '\'' +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        java.util.Stack<Digimon> digidex = new java.util.Stack();
        digidex.push(new Digimon("Botamon"));
        digidex.push(new Digimon("Agumon"));
        digidex.push(new Digimon("Betamon"));

        // pop and print
        // pop removes and returns the object at the top
        // prints the top one... "betamon"
        System.out.println("The top digimon is: " + digidex.pop());

        // another pop
        // removes the 2nd one and stores it in someDigimon
        // ref var... but it's gone from the stack
        Digimon someDigimon = digidex.pop();  // agumon

        // peek just returns top... remains in the stack
        // so in this case... peek returns
        System.out.println("The top digimon is: " + digidex.peek());
        // botamon
        // however, botamon is still in the stack

        System.out.println(digidex.size()); // <-- should still be 1

        System.out.println("the one we popped and stored in someDigimon ref var is: " + someDigimon);


    }
}

class ArrayStack<T> implements Stack<T> {
    private final int DEFAULT_CAPACITY = 9;
    private T[] stack;
    private int count;

    public ArrayStack() {
        // don't worry this next line of code
        // this is what i typically would want to do:
        // stack = new T[DEFAULT_CAPACITY];
        stack = (T[])new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int size) {
        stack = (T[])new Object[size];
    }

    // interface we worked on during class is not the full
    // interface that is in the assignment, so ...
    // check your work

    @Override
    public void push(T value) throws IllegalStateException {
        /*
        don't forget to do some kind of count check
        throw exception if the array is full
         */
    }

    @Override
    public T peek() {
        return stack[0];
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();

        return o.toString();
    }
}
