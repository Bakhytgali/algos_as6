import java.util.*;

public class MyGraph<V> {
    private Map<Vertex, List<Edge<V>>> list;
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
    public boolean hasEdge(Vertex source, Vertex dest){
        validateVertex(source);
        validateVertex(dest);
        List<Vertex> neighbors = list.get(source);
        return neighbors != null && neighbors.contains(dest);
    }
    public void removeEdge(Vertex source, Vertex dest) {
        validateVertex(source);
        validateVertex(dest);
        List<Vertex> neighbors = list.get(source);
        if(neighbors != null) {
            neighbors.remove(dest);
        } list.get(dest).remove(source);
    }
    public List<Vertex> getNeighbors(Vertex vertex){
        validateVertex(vertex);
        return list.getOrDefault(vertex, new LinkedList<>());
    }
    public void DFS(Vertex start) {
        validateVertex(start);
        Map<Vertex, Boolean> visited = new HashMap<>();
        for(Vertex vertex : list.keySet()) {
            visited.put(vertex, false);
        }
        DFSHelper(start, visited);
    }
    private void DFSHelper(Vertex vertex, Map<Vertex, Boolean> visited){
        visited.put(vertex, true);
        System.out.print(vertex + " ");
        for(Vertex neighbor : list.get(vertex)){
            if(!visited.get(neighbor)) {
                DFSHelper(neighbor, visited);
            }
        }
    }
    public Map<Vertex, Double> dijkstra(Vertex start) {
        Map<Vertex, Double> distances = new HashMap<>();
        for (Vertex node : list.keySet()) {
            distances.put(node, Double.MAX_VALUE);
        }
        distances.put(start, 0d);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (Edge neighbor : list.get(currentVertex)) {
                double distance = distances.get(currentVertex) + neighbor.getWeight();

                if (distance < distances.get(currentVertex)) {
                    distances.put(currentVertex, distance);
                    queue.add((Vertex) neighbor.getDest());
                }
            }
        }

        return distances;
    }
}

