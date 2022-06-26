public class Edge {
    private Node _from;

    private Node _to;

    private String _value;

    public Edge(Node from, Node to, String value) {
        _from = from;
        _to = to;
        _value = value;
    }

    public Node getFrom(){
        return _from;
    }

    public Node getTo(){
        return _to;
    }

    public String getValue(){
        return _value;
    }
}