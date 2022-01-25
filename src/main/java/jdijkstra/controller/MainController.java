// BWOTSHEWCHB

package jdijkstra.controller;

import java.util.Scanner;

import jdijkstra.model.elements.map.*;
import jdijkstra.model.elements.list.*;
import jdijkstra.model.elements.graph.*;

public class MainController {
	// Fields
	private Graph graph;
	private Scanner scanner;
	// Constructor
	public MainController() {
		graph = new Graph();
		scanner = new Scanner(System.in);
	}
	// Methods
	public void mainLoop() {
		while(true) {
			String command = scanner.nextLine();
			if (command.equals("input")) {
				this.runInput();
			} else if(command.equals("test")) {
				this.runTest();
			} else if(command.equals("dijkstra")) {
				this.runDijkstra();
			} else if(command.equals("exit")) {
				break;
			} else {
				System.out.println("Unknown Command!");
			}
		}
	}
	public void runInput() {
		graph = new Graph();
		// paramLine[0]: nodeCount, paramLine[1]: edgeCount
		String paramLine[] = scanner.nextLine().split(" ");
		String NodeLine[] = scanner.nextLine().split(" ");
		for (int it = 0; it < Integer.parseInt(paramLine[0]); it += 1) {
			graph.newNode(Integer.parseInt(NodeLine[it]));
		}
		for (int it = 0; it < Integer.parseInt(paramLine[1]); it += 1) {
			// edgeLine[0]: to, edgeLine[1]: from, edgeLine[2]: weight
			String edgeLine[] = scanner.nextLine().split(" ");
			graph.newEdge(Integer.parseInt(edgeLine[0]), Integer.parseInt(edgeLine[1]), Integer.parseInt(edgeLine[2]));
		}
	}
	public void runTest() {
		List<Node> nodeList = graph.getNodeList();
		for (int it = 0; it < graph.getNodeCount(); it += 1) {
			System.out.print(nodeList.getByIndex(it).getId() + " ");
		}
		System.out.println();
	}
	public void runDijkstra() {
		graph.calcDist();
		List<Node> nodeList = graph.getNodeList();
		for (int it = 0; it < graph.getNodeCount(); it += 1) {
			Node currentNode = nodeList.getByIndex(it);
			Map <Node, Integer> map = currentNode.getDistMap();
			System.out.println(currentNode.getId() + ": ");
			for (int jt = 0; jt < graph.getNodeCount(); jt += 1) {
				Node targetNode = nodeList.getByIndex(jt);
				System.out.print(targetNode.getId() + ", " + map.get(targetNode) + "\t");
			}
			System.out.println();
		}
	}
}

