package com.myown.ds.algo.pattern.matcher;

import java.util.Scanner;
import java.util.Stack;

/**
 * The Class CharacterPatternMatcher.
 */
public class CharacterPatternMatcher {

	/**
	 * Find possible smallest number matching pattern.
	 *
	 * @param pattern the pattern
	 * @return the int
	 */
	int findPossibleSmallestNumberMatchingPattern(String pattern) {
	    String result = "";
	    
	    // create an empty stack of integers
	    Stack<Integer> stk = new Stack<>();

	    // run n+1 times where n is length of input pattern
	    for (int i = 0; i <= pattern.length(); i++)
	    {
	        // push number i+1 into the stack
	        stk.push(i + 1);
	 
	        // if all characters of the input sequence are
	        // processed or current character is 'I'
	        // (increasing)
	        if (i == pattern.length() || pattern.charAt(i) == 'N')
	        {
	            // run till stack is empty
	            while (!stk.empty())
	            {
	                // remove top element from the stack and
	                // add it to solution
	                result += String.valueOf(stk.peek());
	                stk.pop();
	            }
	        }
	    }	return Integer.parseInt(result);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("Enter pattern : ");
		Scanner scanner = new Scanner(System.in);
		String pattern = scanner.nextLine();
		CharacterPatternMatcher characterPatternMatcher = new CharacterPatternMatcher();
		int result = characterPatternMatcher.findPossibleSmallestNumberMatchingPattern(pattern);
		System.out.print("Output is : " + result);
	}
}
