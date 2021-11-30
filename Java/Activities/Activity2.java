package activities;

import java.util.Arrays;

public class Activity2 {
	
	public static void main(String[] args) {
		
		int[] numArray = {10, 77, 10, 54, -11, 10};
		System.out.println("Original array : " + Arrays.toString(numArray));
		
		int searchNum = 10;
		int sumNum = 30;

		System.out.println("Result: " + result(numArray, searchNum, sumNum));
		
	}
	
	public static boolean result(int[] numArray, int searchNum, int sumNum) {
		
		int totalValue = 0;
		for (int i : numArray) {
			
			if (i == searchNum) {
				
				totalValue += i;
				
			}
			
		}
				
		return totalValue == sumNum;
		
	}

}
