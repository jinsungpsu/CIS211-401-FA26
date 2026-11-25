public class GenericAdjMatrixGraph<T> {
    public static void main(String[] args) {
        GenericAdjMatrixGraph<String> airports = new GenericAdjMatrixGraph();
        airports.addNode("PHL");
        airports.addNode("ILG");

        airports.addEdge("PHL", "ILG");
    }

    private int count;
    final private int DEFAULT_CAPACITY = 5;
    private boolean[][] adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    private T[] nodes = (T[])(new Object[DEFAULT_CAPACITY]);

    public void addNode(T node) {
        nodes[count++] = node;
    }
    public void addEdge(T src, T dest) {

    }
}
