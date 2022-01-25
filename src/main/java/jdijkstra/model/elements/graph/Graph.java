// BWOTSHEWCHB

package jdijkstra.model.elements.graph;

import java.util.PriorityQueue;

import jdijkstra.model.elements.*;
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
	private Node findStartNode() {
		int tag = 0;
		while (this.nodeMap.get(tag) == null) {
			tag += 1;
		}
		return this.nodeMap.get(tag);
	}
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
		Node targetNode = findStartNode();
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
	public void calcDist() {
		List<Node> nodeList = getNodeList();
		for (int it = 0; it < nodeList.getSize(); it += 1) {
			Node currentNode = nodeList.getByIndex(it);
			List<Pair<Node, Integer>> distList = dijkstra(currentNode);
			for (int jt = 0; jt < distList.getSize(); jt += 1) {
				Pair<Node, Integer> pair = distList.getByIndex(jt);
				currentNode.getDistMap().put(pair.getKey(), pair.getValue());
			}
		}
	}
	public List<Pair<Node, Integer>> dijkstra(Node source) {
		int INF = Integer.MAX_VALUE;
		Map<Integer, Integer> dist = new Map<Integer, Integer>();
		List<Node> nodeList = getNodeList();
		for (int it = 0; it < nodeList.getSize(); it += 1) {
			dist.put(nodeList.getByIndex(it).getId(), INF);
		}
		dist.put(source.getId(), 0);
		PriorityQueue<IntegerPair> queue = new PriorityQueue<IntegerPair>();
		queue.add(new IntegerPair(dist.get(source.getId()), source));
		while (queue.size() > 0) {
			IntegerPair lightest = queue.remove();
			Node node = lightest.getNode();
			List<Edge> list = node.getAdjList();
			for (int it = 0; it < list.getSize(); it += 1) {
				Edge edge = list.getByIndex(it);
				int v = edge.getFrom().getId();
				int u = edge.getTo().getId();
				int w = edge.getWeight();
				if (dist.get(u) > dist.get(v) + w) {
					queue.remove(new IntegerPair(dist.get(u), edge.getTo()));
					dist.put(u, dist.get(v) + w);
					queue.add(new IntegerPair(dist.get(u), edge.getTo()));
				}
			}
		}
		List<Pair<Node, Integer>> list = new List<Pair<Node, Integer>>();
		for (int it = 0; it < nodeList.getSize(); it += 1) {
			Node currentNode = nodeList.getByIndex(it);
			list.append(new Pair<Node, Integer>(currentNode, dist.get(currentNode.getId())));
		}
		return list;
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

