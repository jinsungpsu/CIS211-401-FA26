public class ArrayAdjMatrix {
    // test
    public static void main(String[] args) {
        ArrayAdjMatrix intGraph = new ArrayAdjMatrix();
        intGraph.addEdge(0, 1);
        intGraph.addEdge(1, 2);
        intGraph.addEdge(0, 3);

        System.out.println(intGraph.hasEdge(1,3));
        System.out.println(intGraph.hasEdge(3,0));

        intGraph.printNeighbors(0);
    }


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

    public void printNeighbors(int src) {
        for (int i = 0; i < adjMatrix.length; i++) {
            // this loop iterates through columns
            // if (adjMatrix[src][i] == true) {
            if (hasEdge(src, i)) {
                System.out.print(i + " ");
            }
        }
    }



}
