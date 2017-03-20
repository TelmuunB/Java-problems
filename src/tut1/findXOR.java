package tut1;

import java.util.Scanner;

public class findXOR {
	public static void main(String[] args) {
		try {
			// Reading from System.in
			Scanner reader = new Scanner(System.in);  
			// System input
			System.out.print("Enter N:");
			int N = reader.nextInt();
			System.out.print("Enter M:");
			int M = reader.nextInt();
			if(M>N) {
				int listLength = M-N+1;
				int[] intList = new int[listLength];
				// populate list
				for(int i=0; i<listLength; i++) {
					intList[i] = N;
					N++;
				}
				int[] newList = null;
				int[] result = reduceList(intList, newList, listLength);
				System.out.println(result[0]);
			} else {
				System.out.println("M should greater than N");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**Calculate two given numbers XOR*/
	private static int calculateXOR (int a, int b) {
		int result = 0;
		// Convert to binary
		String binA = Integer.toString(a,2);
		String binB = Integer.toString(b,2);
		// add leading zeros
		if(binA.length()>binB.length()) {
			binB = String.format("%0"+binA.length()+"d", Integer.valueOf(binB));
		} else {
			binA = String.format("%0"+binB.length()+"d", Integer.valueOf(binA));
		}
		String xorString = "";
		// XOR operator in each bit
		for(int i=0; i<binA.length(); i++) {
			int xor = binA.charAt(i) ^ binB.charAt(i);
			xorString = xorString + String.valueOf(xor); 
		}
		// convert to decimal
		result = Integer.parseInt(xorString,2);
		return result;
	}

	/**recursively reduce list*/
	private static int[] reduceList(int[] list, int[] newList, int length) {
		for(int k=0; k<length; k++) {
			System.out.print(list[k]+",");
		}
		System.out.println();
		int newListLength = 0;
		// if length of list odd
		if(length%2 == 1) {
			newListLength = length/2 + 1;
		// if length of list even
		} else {
			newListLength = length/2;
		}
		newList = new int[newListLength];
		int count = 0;
		for(int i=0; i<newListLength; i++) {
			// if length of the list not divided by 4
			// if length of the list odd number
			// set middle element to the new list
			if(length%4!=3 && length%2==1 && length/2==count) {
				newList[i] = list[count];
			} else {
				// calculate XOR from the list 
				newList[i] = calculateXOR(list[count],list[++count]);
				// if there is 3 elements left in middle
				// middle element will be paired with two beside elements
				if(length%4==3&&(length/2-1==count||length/2==count)) {
					// no operation
				} else {
					count++;
				}
			}
		}
		// if list have an one element return
		if(newListLength == 1) return newList;
		// if length of list odd number
		else if(newListLength!=1 && length%2==1) {
			return reduceList(newList, newList, length/2+1);
		} else {
		// if length of list even number
			return reduceList(newList, newList, length/2);
		}
	}

}
