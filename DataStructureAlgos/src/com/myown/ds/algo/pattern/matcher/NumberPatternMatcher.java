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
		System.out.println("Enter numbers : ");
		for (int index = 0; index < num; index++) {
			arr[index] = scanner.nextInt();
		}
		String result = findQualifiedNumbers(arr);
		System.out.println("Output containing 1, 2 and 3 : " + result);
	}
	
	/**
	 * Find qualified numbers.
	 *
	 * @param numberArray the number array
	 * @return the string
	 */
	static String findQualifiedNumbers(int[] numberArray) {
        List<Integer> eligibleNumbers = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(int index=0; index<numberArray.length; index++) {

            //Converting the number to string, with this we'll be able to call the contains method directly.
            String numberString = String.valueOf(numberArray[index]);
            // Main condition
            if (numberString.contains("1") && numberString.contains("2") && numberString.contains("3") ) {
                eligibleNumbers.add(numberArray[index]);
            }
        }
        // Sorting the result as the per the requirement.
        Collections.sort(eligibleNumbers);

        // Append a , as required
        for(int item:eligibleNumbers) {
            builder.append(item).append(",");
        }
        //removing the additional, at the end.
        if(builder.length()>0) {
            builder.setLength(builder.length()-1);
            return builder.toString();
        } else {
            //edge case
            return "-1";
        }
    }

}
