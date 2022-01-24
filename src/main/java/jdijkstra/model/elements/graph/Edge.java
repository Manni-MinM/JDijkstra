// BWOTSHEWCHB

package jdijkstra.model.elements.graph;

public class Edge {
	// Fields
	private Node from;
	private Node to;
	private int weight;
	// Constructor
	public Edge(Node from, Node to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	// Getters
	public Node getFrom() {
		return this.from;
	}
	public Node getTo() {
		return this.to;
	}
	public int getWeight() {
		return this.weight;
	}
	// Methods
	@Override
	public String toString() {
		String ret = "EDGE\n" + this.to.getId() + ", " + this.weight + "\n";
		return ret;
	}
}

