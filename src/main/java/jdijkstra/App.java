package jdijkstra;

import jdijkstra.model.elements.map.*;
import jdijkstra.model.elements.list.*;
import jdijkstra.model.elements.graph.*;

public class App {
	public static void main(String[] args) {
		// Sample testcase
		Graph graph = new Graph();

		graph.newNode(10);
		graph.newNode(7);
		graph.newNode(19);
		graph.newNode(20);
		graph.newNode(1);

		graph.newEdge(10, 7, 50);
		graph.newEdge(19, 7, 20);
		graph.newEdge(7, 20, 1);
		graph.newEdge(1, 20, 5);

		System.out.println(graph.toString());
	}
}
