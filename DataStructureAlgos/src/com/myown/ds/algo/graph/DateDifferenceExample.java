package com.myown.ds.algo.graph;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDifferenceExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number of person");
		int persons = scanner.nextInt();

		String[][] dateArray = new String[persons][3];
		for (int row = 0; row < persons; row++) {
			System.out.println("Enter start date for " + (row + 1) + " person : ");
			dateArray[row][0] = scanner.next();
			System.out.println("Enter stop date for " + (row + 1) + " person : ");
			dateArray[row][1] = scanner.next();
			System.out.println("Enter price for " + (row + 1) + " person : ");
			dateArray[row][2] = scanner.next();
		}
		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");

		Date d1 = null;
		Date d2 = null;
		long[] priceArr = new long[persons];
		try {
			for (int row = 0; row < persons; row++) {
				d1 = format.parse(dateArray[row][0]);
				d2 = format.parse(dateArray[row][1]);

				// in milliseconds
				long diff = d2.getTime() - d1.getTime();
				long diffMinutes = diff / (1000 * 60 * 60);
				//System.out.println(diffMinutes + " minutes, ");
				priceArr[row] = diffMinutes * Long.valueOf(dateArray[row][2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Collections.sort(priceArr, new PriceComparator());
		// Collections.max(Arrays.asList(priceArr), new PriceComparator());
		long max = priceArr[0];
		int person = 0;
		for (int i = 0; i < persons; i++) {
			if (max < priceArr[i]) {
				max = priceArr[i];
				person = i;
			}
		}
		System.out.println("Maximum price " + max + " for the person " + (person + 1) + " is allocated the car");
	}

	// public class PriceComparator implements Comparator {
	//
	// @Override
	// public int compare(Object o1, Object o2) {
	// Long i1 = (Long) o1;
	// Long i2 = (Long) o2;
	// return (int) (i1 - i2);
	// }
	// }
}
