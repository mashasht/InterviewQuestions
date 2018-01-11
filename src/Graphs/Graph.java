package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	int edgeCount;
	int verticesCount;
	Map<Vertex, List<Vertex>> adjacencyList = new HashMap<>();
	
	public Set<Vertex> getAllVertices(){
		return adjacencyList.keySet();
	}
	
	public List<Vertex> getAdjacentVertices(Vertex v){
		return adjacencyList.get(v);
	}
	
	public void addVertex(Vertex v){
		if (!adjacencyList.containsKey(v)) {
			adjacencyList.put(v, new LinkedList<Vertex>());
			verticesCount++;
		}
	}
	public void addEdge(Vertex start, Vertex end) {
		List<Vertex> adjacentToStart = adjacencyList.get(start);
		if (adjacentToStart == null) {
			return;
		}
		if (adjacentToStart.stream().filter(e -> e.equals(end)).findAny().isPresent()) {
			return;
		}
		adjacentToStart.add(end);
		edgeCount++;
	}
}
