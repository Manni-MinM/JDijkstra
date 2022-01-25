// BWOTSHEWCHB

package jdijkstra.model.elements;

import java.util.*;

import jdijkstra.model.elements.graph.*;

public class IntegerPair implements Comparable<IntegerPair> {
	// Fields
	private int dist;
	private Node node;
	// constructor
	public IntegerPair(int dist, Node node) {
		this.dist = dist;
		this.node = node;
	}
	// Getters
	public int getDist() {
		return this.dist;
	}
	public Node getNode() {
		return this.node;
	}
	// Methods
	@Override
	public int compareTo(IntegerPair secondPair) {
		if (this.dist > secondPair.dist) {
			return 1;
		} else if (this.dist < secondPair.dist) {
			return -1;
		} else {
			return 0;
		}
	}
}

