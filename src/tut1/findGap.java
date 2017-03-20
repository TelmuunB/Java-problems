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
