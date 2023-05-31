public class Main {
    public static void main(String[] args) {
        MyGraph<Integer> gr = new MyGraph<>();
        gr.addVertex(1);
        gr.addVertex(3);
        gr.addVertex(2);
        gr.addVertex(4);
        gr.addEdge(1, 3);
        gr.addEdge(1,2);
        gr.addEdge(2,3);
        gr.addEdge(3,4);
        gr.printGraph();
        gr.removeEdge(1,3);
        gr.printGraph();
        gr.hasEdge(2,3);
    }
}