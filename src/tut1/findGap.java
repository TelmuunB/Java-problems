/*
*A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
*For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
*Write a function:
*int solution(int N);
*that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
*For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
*/
package tut1;

import java.util.Scanner;

public class findGap {
	public static void main(String[] args) {
		// Reading from System.in
		Scanner reader = new Scanner(System.in);  
		// System input
		System.out.print("Enter a number:");
		int n = reader.nextInt();
		int maxGap = 0;
        if (n>0) {
            // Convert to binary
        	String bin = Integer.toString(n,2);
            System.out.println(bin);
            int gapCount = 0;
            // Check each binary string character
            for (int i=0; i<bin.length(); i++ ) {
            	// count zero between 1
                if(bin.charAt(i)!='1') {
                     gapCount++;
                } else {
                	// if current gap greater than current
                    if(gapCount>maxGap) {
                    	// set maximum number
                        maxGap = gapCount;
                    }
                    gapCount = 0;
                }
            }
            System.out.println(maxGap);
        }
	}
}
