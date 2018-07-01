package com.myown.ds.algo.graph;

/**
 * The Class CalculateKElement.
 */
public class CalculateKElement {

	/** The start. */
	private Node start;
	
	/**
	 * The Class Node.
	 */
	class Node {
		
		/** The data. */
		int data;
		
		/** The next. */
		Node next;
		
		/**
		 * Instantiates a new node.
		 *
		 * @param data the data
		 */
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/**
	 * Push.
	 *
	 * @param data the data
	 */
	private void push(int data) {
		Node node = new Node(data);
		if(start == null) {
			start = node;
		} else {
			Node temp = start;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		
	}
	
	/**
	 * Prints the list.
	 */
	private void printList() {
		if(start == null) {
			System.out.println("List is empty!");
		} else {
			Node temp = start;
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	
	/**
	 * Prints the K element.
	 *
	 * @param k the k
	 */
	private void printKElement(int k) {
		int count = 0;
		Node temp = start;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		System.out.println("Count : " + count);
		temp = start;
		for(int index = 0; index < count-k; index++) {
			temp = temp.next;
		}
		System.out.println(k + "rd element : " + temp.data);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		CalculateKElement calculateKElement = new CalculateKElement();
		calculateKElement.push(10);
		calculateKElement.push(20);
		calculateKElement.push(30);
		calculateKElement.push(40);
		calculateKElement.push(50);
		calculateKElement.printList();
		calculateKElement.printKElement(3);
	}
}
