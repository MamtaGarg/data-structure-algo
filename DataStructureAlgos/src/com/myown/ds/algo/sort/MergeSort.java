package com.myown.ds.algo.sort;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Before Sorting : - ");
		mergeSort.printArray(arr);
		mergeSort.sort(arr, 0, arr.length - 1);
		System.out.println("After Sorting : - ");
		mergeSort.printArray(arr);
	}

	public void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private void merge(int[] arr, int l, int m, int r) {
		int n1 = m -l + 1;
		int n2 = r - m;
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];
		for (int i = 0; i < n1; ++i) {
			temp1[i] = arr[l + i];
		}
		for (int i = 0; i < n2; ++i) {
			temp2[i] = arr[m + 1 + i];
		}
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (temp1[i] < temp2[j]) {
				arr[k] = temp1[i];
				i++;
				k++;
			} else {
				arr[k] = temp2[j];
				j++;
				k++;
			}
		}
		while (i < n1) {
			arr[k] = temp1[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = temp2[j];
			j++;
			k++;
		}
	}

	private void printArray(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + " ");
		}
	}
}
