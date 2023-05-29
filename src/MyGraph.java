import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Vertex>> list;
    public MyGraph(){
        list = new HashMap<>();
    }
}
