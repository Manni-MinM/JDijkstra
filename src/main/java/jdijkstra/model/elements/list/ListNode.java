// BWOTSHEWCHB

package jdijkstra.model.elements.list;

public class ListNode<T> {
	// Fields
	private T data;
	private ListNode<T> next;
	// Constructor
	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}
	// Setters
	void setData(T data) {
		this.data = data;
	}
	void setNext(ListNode<T> next) {
		this.next = next;
	}
	// Getters
	T getData() {
		return this.data;
	}
	ListNode<T> getNext() {
		return this.next;
	}
}

