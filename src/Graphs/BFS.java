package Graphs;
import java.util.LinkedList;
import java.util.List;

public class BFS {
	/**
	 * Only for trees case
	 * @param graph
	 * @param start
	 * @return
	 */
	public static List<Vertex> bfsTraversal(Graph graph, Vertex start){
		List<Vertex> visitedVertices = new LinkedList<>();
		List<Vertex> unvisitedVertices = new LinkedList<>();
		unvisitedVertices.add(start);
		while(!unvisitedVertices.isEmpty()) {
			Vertex current = unvisitedVertices.remove(0);
			unvisitedVertices.addAll(graph.getAdjacentVertices(current));
			visitedVertices.add(current);
		}
		return visitedVertices;
	}
	public static void main(String[] args) {
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Graph graph = new Graph();
		graph.addVertex(one);
		graph.addVertex(two);
		graph.addVertex(three);
		graph.addEdge(one, two);
		graph.addEdge(one, three);
		List<Vertex> traversed = bfsTraversal(graph, one);
		System.out.println(traversed);
	}
}
