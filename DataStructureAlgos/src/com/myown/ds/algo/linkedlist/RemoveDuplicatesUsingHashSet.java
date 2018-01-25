package com.myown.ds.algo.linkedlist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {

	static Node start;
	
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	private static void insertElement(int data) {
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
	
	private static void printValues() {
		if(start == null) {
			System.out.println("List is empty.");
		} else {
			Node temp = start;
			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}
	
	private static void removeDuplicatesUsingHash() {
		Set<Integer> hashSet = new HashSet<>();
		Node temp = start;
		Node prev = temp;
		while(temp != null) {
			if(hashSet.contains(temp.data)) {
				prev.next = temp.next;
			} else {
				hashSet.add(temp.data);
				prev = temp;
			}
			temp = prev.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the values you want to insert :-");
		int data = scanner.nextInt();
		do {
			insertElement(data);
			data = scanner.nextInt();
		} while(data != 0);
		
		System.out.println("Inserted values are :-");
		printValues();
		// remove elements using merge sort
		//mergeSortAndRemoveDuplicates();
		removeDuplicatesUsingHash();
		System.out.println("\nAfter remove duplicates values are :-");
		printValues();
	}

}
