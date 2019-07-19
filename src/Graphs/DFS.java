package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/*public class DFS {
	enum Color{
		WHITE, GREY, BLACK;
	}
	class DFSVertex{
		Vertex vertex;
		Color color;
		DFSVertex(Vertex vertex, Color color){
			this.vertex = vertex;
			this.color = color;
		}
	}
	public Set<List<Vertex>> sort(Graph g){
		Set<Vertex> vertices = g.getAllVertices();
		Set<DFSVertex> dfsVertices = new HashSet<>();
		Set<List<Vertex>> dfsForest = new HashSet<>();
		for(Vertex v: vertices) {
			dfsVertices.add(new DFSVertex(v, Color.WHITE));
		}
		if (dfsVertices.isEmpty()) {
			return dfsForest;
		}
		
		while(!dfsVertices.isEmpty()) {
			DFSVertex current = dfsVertices.iterator().next();
			if (current.color == Color.WHITE) {
				List<Vertex> dfsTraversal = new LinkedList<Vertex>();
				
			}
		}
	}
	private static void visit(Graph g, DFSVertex v, Set<DFSVertex> dfsVertices, List<Vertex> dfsTraversal) {
		dfsTraversal.add(v.vertex);
		List<Vertex> adjacentNodes = g.getAdjacentVertices(v.vertex);
		for (Vertex adV: adjacentNodes) {
			DFSVertex adDFS = dfsVertices.stream().filter(e -> e.vertex == adV).findAny().get();
			visit(g, adDFS, dfsVertices, dfsTraversal);
		}
	}

}*/
