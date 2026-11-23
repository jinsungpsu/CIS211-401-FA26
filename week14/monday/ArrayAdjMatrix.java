public class ArrayAdjMatrix {
    /*
    Yes  it's an array
    but some of the details will change
    based on directed/undirected
    weighted/unweighted

    start with this one:
    directed, unweighted

    this one only holds integers
     */
    private boolean[][] adjMatrix;

    /*
    other options
     */
    private int[][] adjMatrixWeighted;

    private int DEFAULT_CAPACITY = 5; // only 5 vertices can go into this

    public ArrayAdjMatrix() {
        adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    /*
    add edge will always have
    source & destination
    in this case, it's just integers
    specifically, integers between 0 and DEFAULT_CAP - 1
     */
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = true;
    }

    public boolean hasEdge(int src, int dest) {
        return adjMatrix[src][dest];
    }

}
