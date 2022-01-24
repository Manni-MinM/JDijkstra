// BWOTSHEWCHB

package jdijkstra.model.elements.map;

import jdijkstra.model.elements.list.*;

public class Bucket<K, V> {
	// Fields
	private List<Pair<K, V>> list;
	// Constructor
	public Bucket() {
		this.list = new List<Pair<K, V>>() ;
	}
	// Getters
	public List<Pair<K, V>> getList() {
		return this.list;
	} 
}

