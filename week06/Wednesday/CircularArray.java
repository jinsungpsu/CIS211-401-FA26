/*
every other
itr = itr.next.next;
 */
public class CircularArray {
    final int DEFAULT_CAPACITY = 5;
    private int[] stuff;
    private int count = 0;
    private int front, rear; // help us facilitate a more queue like implementation

    public CircularArray() {
        stuff = new int[DEFAULT_CAPACITY];
    }

    public CircularArray(int size) {
        stuff = new int[size];
    }

    public void enqueue(int item) {
        // no shifts!
        // no loops!
        // this is O(1)

        if (count == stuff.length) {
            // my array is full
            return;
        } else {
            // there's some space in the array
            // because i didn't shift..
            // the space is somewhere else
            // so i need to implement circularity

            if (rear >= stuff.length) {
                // do something different
                // because I 'fell' off the array
                rear = 0;
                // alternatively
                // rear -= stuff.length;

            }

            stuff[rear++] = item;
            count++;
        }
    }

    public int dequeue() {
        // no shifts!
        // no loops!
        // this is O(1)

        // we need to also take circularity into account
        count--;
        stuff[front] = -999;
        return stuff[front++];
    }

    public int peek() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}

class CircularTest {
    public static void main(String[] args) {
        CircularArray list = new CircularArray();
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);

        System.out.println("Dequeued: " + list.dequeue());
        System.out.println("Dequeued: " + list.dequeue());
        System.out.println("Dequeued: " + list.dequeue());

        list.enqueue(6); // can't do this... it's full
        list.enqueue(7); // can't do this... it's full
        list.enqueue(8); // can't do this... it's full

        System.out.println("Dequeued: " + list.dequeue());
        System.out.println("Dequeued: " + list.dequeue());
        System.out.println("Dequeued: " + list.dequeue());

        list.enqueue(9); // can't do this... it's full
        list.enqueue(10); // can't do this... it's full
        list.enqueue(11); // can't do this... it's full


    }
}
