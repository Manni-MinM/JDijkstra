// BWOTSHEWCHB

package jdijkstra.model.elements.list;

import jdijkstra.model.elements.graph.*;

public class List<T> {
	// Fields
	private int size;
	private ListNode<T> head;
	private ListNode<T> tail;
	// Constructor
	public List() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	// Getters
	public int getSize() {
		return this.size;
	}
	// Methods
	public void append(T data) {
		ListNode newListNode = new ListNode(data);
		if ( head == null ) {
			this.head = newListNode;
			this.tail = newListNode;
		} else {
			this.head.setNext(newListNode);
			this.head = newListNode; 
		}
		this.size += 1;
	}
	public T getByIndex(int index) {
		if (index >= this.size) {
			return null;
		}
		ListNode<T> currentNode = this.tail;
		for (int i = 0; i < index; i += 1) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}
}

