// BWOTSHEWCHB

package jdijkstra.model.elements.map;

public class Pair<K, V> {
	// Fields
	private K key;
	private V value;
	// Constructor
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	// Getters
	K getKey() {
		return this.key;
	}
	V getValue() {
		return this.value;
	}
	// Setters
	void setValue(V value) {
		this.value = value;
	}
	// Methods
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object instanceof Pair) {
			Pair pair = (Pair)object;
			return ((this.key == pair.getKey()) && (this.value == pair.getValue()));
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO
		return key.hashCode();
	}
}

