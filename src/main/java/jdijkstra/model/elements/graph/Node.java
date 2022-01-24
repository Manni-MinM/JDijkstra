// BWOTSHEWCHB

package jdijkstra.model.elements.graph;

import jdijkstra.model.elements.list.*;

public class Node {
	// Fields
	private int id;
	private List<Edge> adjList;
	// Constructor
	public Node(int id) {
		this.id = id;
		this.adjList = new List<Edge>();
	}	
	// Getters
	public int getId() {
		return this.id;
	}
	public List<Edge> getAdjList() {
		return this.adjList;
	}
	// Methods
	void addAdjNode(Node to, int weight) {
		adjList.append(new Edge(this, to, weight));
	}
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object instanceof Node) {
			Node node = (Node)object;
			return (this.id == node.id);
		}
		return false;
	}
	@Override
	public int hashCode() {
		//TODO
		return this.id;
	}
}

