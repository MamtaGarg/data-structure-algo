package com.myown.ds.algo.pattern.matcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The Class NumberPatternMatcher.
 */
public class NumberPatternMatcher {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of digits : ");
		int num = scanner.nextInt();
		int[] arr = new int[num];
		List<Integer> list = new ArrayList<>();
		System.out.println("Enter numbers : ");
		for (int index = 0; index < num; index++) {
			arr[index] = scanner.nextInt();
		}
		for (int index = 0; index < num; index++) {
			int n = arr[index];
			int digit, count = 0;
			while (n > 0) {
				digit = n % 10; // get the digit
				if (digit == 1 || digit == 2 || digit == 3)
					count++;
				n = n / 10;
			}
			if (count >= 3) {
				list.add(arr[index]);
			}
		}
		Collections.sort(list);
		System.out.println("Output containing 1, 2 and 3 : ");
		list.forEach(value->System.out.print(value + " "));
	}

}
