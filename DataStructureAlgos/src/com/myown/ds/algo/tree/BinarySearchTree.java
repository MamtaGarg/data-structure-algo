package com.myown.ds.algo.tree;

import java.util.Scanner;

/**
 * The Class Node.
 */
class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

/**
 * The Class BinarySearchTree.
 */
public class BinarySearchTree {

	/** The root. */
	private static Node root = null;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the values you want to insert in tree -");
		int data = scanner.nextInt();
		do {
			tree.insertElement(data);
			data = scanner.nextInt();
		} while (data != 0);
		
		System.out.println("Pre order traversal - ");
		tree.preOrderTraversal(root);
		System.out.println("\nIn order traversal - ");
		tree.inOrderTraversal(root);
		System.out.println("\nPost order traversal - ");
		tree.postOrderTraversal(root);

	}

	/**
	 * Insert element.
	 *
	 * @param data the data
	 */
	private void insertElement(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
		} else {
			Node ptr = root;
			Node pptr = null;
			while (ptr != null) {
				pptr = ptr;
				if (data <= ptr.data) {
					ptr = ptr.left;
				} else {
					ptr = ptr.right;
				}
			}
			if (data <= pptr.data) {
				pptr.left = node;
			} else {
				pptr.right = node;
			}
		}
	}

	/**
	 * Pre order traversal.
	 *
	 * @param ptr the ptr
	 */
	private void preOrderTraversal(Node ptr) {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		// pre-order traversal
		if (ptr != null) {
			System.out.print(ptr.data + " ");
			preOrderTraversal(ptr.left);
			preOrderTraversal(ptr.right);
		}
	}
	
	/**
	 * In order traversal.
	 *
	 * @param ptr the ptr
	 */
	private void inOrderTraversal(Node ptr) {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		// in-order traversal
		if (ptr != null) {
			inOrderTraversal(ptr.left);
			System.out.print(ptr.data + " ");
			inOrderTraversal(ptr.right);
		}
	}
	
	/**
	 * Post order traversal.
	 *
	 * @param ptr the ptr
	 */
	private void postOrderTraversal(Node ptr) {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		// post-order traversal
		if (ptr != null) {
			postOrderTraversal(ptr.left);
			postOrderTraversal(ptr.right);
			System.out.print(ptr.data + " ");
		}
	}
}
