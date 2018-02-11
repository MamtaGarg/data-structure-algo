package com.myown.ds.algo.sort;

import java.util.Scanner;

public class Solution {
    /*
     * Complete the function below.
     */
    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        int countM=0, countN=0;
        int totalDigitsForM = 0, totalDigitsForN = 0;
        int res = 0;
        for(int index=0; index<pattern.length(); index++) {
           char ch = pattern.charAt(index);
           if(ch == 'M')
               countM++;
           if(ch == 'N')
               countN++;
        }

         if(countN == 0) {
             totalDigitsForM = countM+1;
            for(int index=totalDigitsForM; index>0; index--)
                res += index * Math.pow(10, index-1);
            return res;
        }  else if(countM == 0) {
             totalDigitsForN = countN + 1;
            for(int index=1; index<=totalDigitsForN; index++)
                res += index * Math.pow(10, totalDigitsForN-index);
            return res;
        } else {
            totalDigitsForM = countM+1;
            totalDigitsForN = countN + 1;
            int[] resultArrM = new int[totalDigitsForM];
            int[] resultArrN = new int[countN];
             for(int index=0; index<totalDigitsForM; index++) {
                resultArrM[index] = index+1;
             }
            for(int index=0; index<countN; index++) {
                resultArrN[index] = totalDigitsForM + index + 1;
             }

            String result = "";
             int i =1;
            for(int index=0; index<pattern.length(); index++) {
                 char ch = pattern.charAt(index);
               if(ch == 'M') {
                   if(totalDigitsForM > (index+1))   
                         result += String.valueOf(resultArrM[index+1]) + String.valueOf(resultArrM[index]);
                   else
                         result += String.valueOf(resultArrM[index]);
               } 
               if(ch == 'N') {
                   result += String.valueOf(resultArrN[countN - i]);
                   i++;
               }
            }
             res = Integer.parseInt(result);
             return res;
        }
    }
    public static void main(String[] args) {
		System.out.println("Enter pattern : ");
		Scanner scanner = new Scanner(System.in);
		String pattern = scanner.nextLine();
		int result = findPossibleSmallestNumberMatchingPattern(pattern);
		System.out.println(result);
    }
}
