// BWOTSHEWCHB

package jdijkstra.model.elements.graph;

import jdijkstra.model.elements.map.*;
import jdijkstra.model.elements.list.*;

public class Graph {
	// Fields
	private int nodeCount;
	private int edgeCount;
	private Map<Integer, Node> nodeMap;
	// Constructor
	public Graph() {
		this.nodeCount = 0;
		this.edgeCount = 0;
		this.nodeMap = new Map<Integer, Node>();
	}
	// Getters
	public int getNodeCount() {
		return this.nodeCount;
	}
	public int getEdgeCount() {
		return this.edgeCount;
	}
	// Methods
	public void newNode(int id) {
		Node newNode = new Node(id);
		this.nodeMap.put(id, newNode);
	}
	public void newEdge(int from, int to, int weight) {
		Node fromNode = nodeMap.get(from);
		Node toNode = nodeMap.get(to);
		fromNode.addAdjNode(toNode, weight);
		toNode.addAdjNode(fromNode, weight);
	}
	@Override
	public String toString() {
		String ret = "GRAPH\n";
		for (int it = 0; it < this.nodeMap.getCapacity(); it += 1) {
			Node node = nodeMap.get(it);
			if (node != null) {
				ret += node.toString();
			}
		}
		return ret;
	}
}

