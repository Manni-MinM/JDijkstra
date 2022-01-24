// BWOTSHEWCHB

package jdijkstra.model.elements.map;

import jdijkstra.model.elements.list.*;

public class Map<K, V> {
	// Fields
	private int size ;
	private int capacity = (1 << 3);
	private final float LOAD_FACTOR = 0.75f;
	private Bucket<K, V>[] buckets;
	// Constructor
	public Map() {
		this.initiateBuckets();
	}
	// Getters
	public int getSize() {
		return this.size;	
	}
	// Methods
	private void initiateBuckets() {
		this.size = 0;
		this.buckets = new Bucket[this.capacity];
		for(int it = 0; it < this.capacity; it += 1) {
			buckets[it] = new Bucket<K, V>();
		}
	}
	private void reHash() {
		this.capacity *= 2;
		Bucket<K, V>[] prevBuckets = buckets;
		this.initiateBuckets();
		for (Bucket<K, V> bucket: prevBuckets) {
			List<Pair<K, V>> list = bucket.getList();
			for (int it = 0; it < list.getSize(); it += 1) {
				Pair<K, V> pair = list.getByIndex(it);
				put(pair.getKey(), pair.getValue());
			}
		}
	}
	public void put(K key, V value) {
		if (LOAD_FACTOR * this.capacity <= this.size) {
			this.reHash();
		}
		int index = -1;
		int targetIndex = key.hashCode() % this.capacity;
		Pair<K, V> newPair = new Pair<K, V>(key, value);
		List<Pair<K, V>> bucketList = buckets[targetIndex].getList();
		for (int it = 0; it < bucketList.getSize(); it += 1) {
			Pair<K, V> currentPair = bucketList.getByIndex(it);
			if (newPair.getKey().equals(currentPair.getKey())) {
				index = it;
				break;
			}
		}
		if (index != -1) {
			bucketList.setByIndex(index, newPair);
		} else {
			bucketList.append(newPair);
			this.size += 1;
		}
	}
	public V get(K key) {
		int index = key.hashCode() % this.capacity;
		List<Pair<K, V>> bucketList = buckets[index].getList();
		for (int it = 0; it < bucketList.getSize(); it += 1) {
			Pair<K, V> currentPair = bucketList.getByIndex(it);
			if (currentPair.getKey().equals(key)) {
				return currentPair.getValue();
			}
		}
		return null;
	}
}

