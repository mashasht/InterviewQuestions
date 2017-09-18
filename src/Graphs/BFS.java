package Graphs;
import java.util.LinkedList;
import java.util.List;

public class BFS {
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
		Vertex one = new Vertex("one");
		Vertex two = new Vertex("two");
		Vertex three = new Vertex("three");
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
