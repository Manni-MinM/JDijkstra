package jdijkstra;

import jdijkstra.controller.MainController;

public class App {
	// Fields
	private static MainController controller;
	// Methods
	public static void main(String[] args) {
		controller = new MainController();
		controller.mainLoop();
	}
}
