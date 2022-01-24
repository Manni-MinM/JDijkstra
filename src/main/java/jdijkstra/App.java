package jdijkstra;

import jdijkstra.model.elements.map.*;
import jdijkstra.model.elements.list.*;
import jdijkstra.model.elements.graph.*;

public class App {
	public static void main(String[] args) {
		// Sample testcase
		Graph graph = new Graph();

		graph.newNode(2);
		graph.newNode(3);
		graph.newNode(4);
		graph.newNode(5);
		graph.newNode(1);

		graph.newEdge(2, 3, 50);
		graph.newEdge(4, 3, 20);
		graph.newEdge(3, 5, 1);
		graph.newEdge(1, 5, 5);

		System.out.println(graph.toString());
	}
}
