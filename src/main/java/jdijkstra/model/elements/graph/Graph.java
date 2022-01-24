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
		this.nodeCount += 1;
	}
	public void newEdge(int from, int to, int weight) {
		Node fromNode = nodeMap.get(from);
		Node toNode = nodeMap.get(to);
		fromNode.addAdjNode(toNode, weight);
		toNode.addAdjNode(fromNode, weight);
		this.edgeCount += 1;
	}
	public List<Node> getNodeList() {
		int tag = 0;
		while (this.nodeMap.get(tag) == null) {
			tag += 1;
		}
		Node targetNode = this.nodeMap.get(tag);
		Map<Integer, Boolean> mark = new Map<Integer, Boolean>();
		List<Node> list = new List<Node>();
		dfs(targetNode, mark, list);
		return list;
	}
	public void dfs(Node node, Map<Integer, Boolean> mark, List<Node> list) {
		list.append(node);
		mark.put(node.getId(), true);
		List<Edge> adjList = node.getAdjList();
		for (int it = 0; it < adjList.getSize(); it += 1) {
			Node adjNode = adjList.getByIndex(it).getTo();
			if (mark.get(adjNode.getId()) == null) {
				dfs(adjNode, mark, list);
			}
		}
	}
	@Override
	public String toString() {
		String ret = "GRAPH\n";
		List<Node> list = this.getNodeList();
		for (int it = 0; it < list.getSize(); it += 1) {
			Node node = list.getByIndex(it);
			ret += node.toString();
		}
		return ret;
	}
}

