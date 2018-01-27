package com.myown.ds.algo.linkedlist;

import java.util.Scanner;

/**
 * The Class RemoveDuplicates.
 */
// Considering the entered data is sorted
public final class RemoveDuplicates {

	/** The start. */
	static Node start = null;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * Insert element.
	 *
	 * @param data the data
	 */
	private static void insertElement(int data) {
		Node node = new Node(data);
		if (start == null) {
			start = node;
		} else {
			Node temp = start;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	/**
	 * Prints the values.
	 */
	private static void printValues() {
		if (start == null) {
			System.out.println("List is empty.");
		} else {
			Node temp = start;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	/**
	 * Removes the duplicates using merge sort.
	 */
	private static void removeDuplicatesUsingMergeSort() {
		if(start == null || start.next == null) {
			System.out.println("\nList is either empty or contains one element.");
		} else {
			Node temp = start;
			Node nextToTemp = start.next;
			while(nextToTemp != null) {
				if(temp.data == nextToTemp.data) {
					temp.next = nextToTemp.next;
				} else {
					temp = temp.next;
				}
				nextToTemp = temp.next;
			}
		}
		
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the values you want to insert :-");
		int data = scanner.nextInt();
		do {
			insertElement(data);
			data = scanner.nextInt();
		} while (data != 0);

		System.out.println("Inserted values are :-");
		printValues();
		removeDuplicatesUsingMergeSort();
		System.out.println("\nAfter remove duplicates values are :-");
		printValues();
	}

}
