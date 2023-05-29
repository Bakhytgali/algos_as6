import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Vertex>> list;
    public MyGraph(){
        list = new HashMap<>();
    }
    public void addVertex(Vertex vertex){
        list.put(vertex, new LinkedList<>());
    }
    public void addEdge(Vertex source, Vertex dest){
        validateVertex(source);
        validateVertex(dest);
        list.get(source).add(dest);
        list.get(dest).add(source);
    }
    private void validateVertex(Vertex index){
        if(!list.containsKey(index)) {
            throw new IllegalArgumentException();
        }
    }
    public void printGraph(){
        for(Map.Entry<Vertex, List<Vertex>> entry : list.entrySet()){
            Vertex vertex = entry.getKey();
            List<Vertex> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex + " is Connected to ");
            for(Vertex neighbor : neighbors){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
