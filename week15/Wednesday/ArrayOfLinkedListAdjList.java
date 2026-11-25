import java.util.LinkedList;

public class ArrayOfLinkedListAdjList {

    public static void main(String[] args) {
        ArrayOfLinkedListAdjList intGraph = new ArrayOfLinkedListAdjList();
        intGraph.addEdge(0, 1);
        intGraph.addEdge(1, 2);
        intGraph.addEdge(0, 3);

        System.out.println(intGraph.hasEdge(1,3));
        System.out.println(intGraph.hasEdge(3,0));
        System.out.println(intGraph.hasEdge(1,2));

        intGraph.printNeighbors(0);
    }

    /*
    array of linked lists
     */
    private LinkedList<Integer>[] adjList;
    private final int DEFAULT_CAPACITY = 5;

    public ArrayOfLinkedListAdjList() {
        adjList = new LinkedList[DEFAULT_CAPACITY];
    }

    public void addEdge(int src, int dest) {
        if (adjList[src] == null) {
            adjList[src] = new LinkedList<>();
        } else {
            if (adjList[src].contains(dest)) {
                return;
            }
        }
        adjList[src].add(dest);
    }

    public boolean hasEdge(int src, int dest) {
        if (adjList[src] == null) return false; // no linked list at all!  aka .. no neighbors
        return adjList[src].contains(dest);
    }

    public void printNeighbors(int src) {
        if (adjList[src] == null) System.out.println("No neighbors");

        System.out.println(adjList[src]);
    }
}
