package com.myown.ds.algo.sort;

import java.util.Scanner;

/**
 * The Class MergeSortUsingLinkedList.
 */
public class MergeSortUsingLinkedList {

	/** The head. */
	static Node head = null;

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
			next = null;
		}
	}

	/**
	 * Merge sort.
	 *
	 * @param left the left
	 * @param right the right
	 * @return the node
	 */
	private Node mergeSort(Node left, Node right) {
		if(left == null)
			return right;
		else if(right == null)
			return left;
		else {
			Node result = null;
			if(left.data <= right.data) {
				result = left;
				result.next = mergeSort(left.next, right);
			}
			else {
				result = right;
				result.next = mergeSort(left, right.next);
			}
			return result;
		}
	}
	
	/**
	 * Sort.
	 *
	 * @param head the head
	 * @return the node
	 */
	public Node sort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
			Node middle = getMiddle(head);
			Node nextToMiddle = middle.next;
			middle.next = null;
			Node left = sort(head);
			Node right = sort(nextToMiddle);
			Node sortedResult = mergeSort(left, right);
			return sortedResult;
	}

	/**
	 * Gets the middle.
	 *
	 * @param head the head
	 * @return the middle
	 */
	private Node getMiddle(Node head) {
		if (head.next == null) {
			System.out.println("There is a single element in the list");
			return head;
		} else {
			Node slowptr = head;
			Node fastptr = head.next;
			while (fastptr.next != null) {
				fastptr = fastptr.next;
				if (fastptr.next != null) {
					fastptr = fastptr.next;
					slowptr = slowptr.next;
				}
			}
			return slowptr;
		}
	}

	/**
	 * Insert at end.
	 *
	 * @param data the data
	 */
	private void insertAtEnd(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	/**
	 * Prints the list.
	 */
	private void printList() {
		if (head == null)
			System.out.println("List is Empty");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("Enter the elements to be insetred : -");
		MergeSortUsingLinkedList mergeSortObj = new MergeSortUsingLinkedList();
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		do {
			mergeSortObj.insertAtEnd(data);
			data = scanner.nextInt();
		} while (data != 0);
		System.out.println("Before sorting data is : ");
		mergeSortObj.printList();
		head = mergeSortObj.sort(head);
		System.out.println("\nAfter sorting data is : ");
		mergeSortObj.printList();
	}

}
