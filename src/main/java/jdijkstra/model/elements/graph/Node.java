// BWOTSHEWCHB

package jdijkstra.model.elements.graph;

import jdijkstra.model.elements.map.*;
import jdijkstra.model.elements.list.*;

public class Node {
	// Fields
	private int id;
	private List<Edge> adjList;
	private Map<Node, Integer> distMap;
	// Constructor
	public Node(int id) {
		this.id = id;
		this.adjList = new List<Edge>();
		this.distMap = new Map<Node, Integer>();
	}	
	// Getters
	public int getId() {
		return this.id;
	}
	public List<Edge> getAdjList() {
		return this.adjList;
	}
	public Map<Node, Integer> getDistMap() {
		return this.distMap;
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
		return this.id;
	}
	@Override
	public String toString() {
		String adjString = "";
		for (int it = 0; it < this.adjList.getSize(); it += 1) {
			adjString += adjList.getByIndex(it).toString();
		}
		String ret = "NODE\nid: " + this.id + "\nadj:\n" + adjString;
		return ret;
	}
}

