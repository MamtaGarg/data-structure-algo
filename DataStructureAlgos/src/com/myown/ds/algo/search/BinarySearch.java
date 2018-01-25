package com.myown.ds.algo.search;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("Enter number of the elements : ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter Array Elements :- ");
		for (int index = 0; index < n; index++) {
			arr[index] = scanner.nextInt();
		}
		System.out.println("Enter the element to be searched : ");
		int value = scanner.nextInt();
		binarySearch(arr, 0, n - 1, value);
	}

	private static void binarySearch(int[] arr, int low, int high, int value) {
		int mid = (low + high) / 2;
		if (low <= high) {
			if (arr[mid] == value) {
				System.out.println("Element found on " + (mid + 1) + " location");
			} else {
				if (arr[mid] < mid) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
				binarySearch(arr, low, high, value);
			}
		} else {
			System.out.println("Element does not exists in this array.");
		}
	}
}
