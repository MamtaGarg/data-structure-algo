package com.myown.ds.algo.sort;

public class CountInversionUsingMergeSort {

	private static int count = 0;

	public static void main(String[] args) {
		CountInversionUsingMergeSort countInversionUsingMergeSort = new CountInversionUsingMergeSort();
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Before Sorting : - ");
		countInversionUsingMergeSort.printArray(arr);
		int count = countInversionUsingMergeSort.sort(arr, 0, arr.length - 1);
		System.out.println("Total number of inversions are :- " + count);
	}

	private void printArray(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + " ");
		}
	}

	private int sort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			mergeAndCountInversions(arr, low, mid, high);
		}
		return count;
	}

	private void mergeAndCountInversions(int[] arr, int low, int mid, int high) {
		int n1 = mid -low + 1;
		int n2 = high - mid;
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];
		for (int i = 0; i < n1; ++i) {
			temp1[i] = arr[low + i];
		}
		for (int i = 0; i < n2; ++i) {
			temp2[i] = arr[mid + 1 + i];
		}
		int i = 0, j = 0, k = low;
		while (i < n1 && j < n2) {
			if (temp1[i] < temp2[j]) {
				arr[k] = temp1[i];
				i++;
				k++;
			} else {
				count++;
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
			count++;
			arr[k] = temp2[j];
			j++;
			k++;
		}
	}

}
