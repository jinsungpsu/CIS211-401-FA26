import java.util.HashMap;

public class GenericAdjMarixGraph2<T> {
    public static void main(String[] args) {
        GenericAdjMarixGraph2<String> airports = new GenericAdjMarixGraph2();
        airports.addNode("PHL");
        airports.addNode("ILG");
        airports.addNode("EWR");

        airports.addEdge("PHL", "ILG");
        airports.addEdge("PHL", "EWR");
    }

    // better version
    private HashMap<T, HashMap<T, Boolean>> adjMatrixMappings = new HashMap<>();

    public void addNode(T node) {
        adjMatrixMappings.put(node, new HashMap<>());
    }
    public void addEdge(T src, T dest) {
        if (adjMatrixMappings.get(src)!= null)
            adjMatrixMappings.get(src).put(dest, true);
    }
    public boolean hasEdge(T src, T dest) {
        if (adjMatrixMappings.get(src)!= null)
            if (adjMatrixMappings.get(src).get(dest) != null)
                return adjMatrixMappings.get(src).get(dest);
            else
                return false;
        else
            return false;
    }
}
