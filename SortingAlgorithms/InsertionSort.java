package sorting;

import java.util.Scanner;

public class InsertionSort {

	//Time Complexity:				//Space Complexity:
	//Best = O(n)					// O(1)
	//Average = O(n^2)
	//Worst = O(n^2)
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String givenNumbers = in.nextLine();
		in.close();
		String[] stringArray = givenNumbers.split(" ");
		int[] numbersArray = new int[stringArray.length];
		for(int i = 0;i<stringArray.length;i++)
		{
			numbersArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		int[] sortedNumbersArray = insertionSort(numbersArray);
		for(int i:sortedNumbersArray)
		{
			System.out.print(i+" ");
		}
		System.out.println();

	}
	
	public static int[] insertionSort(int[] numbersArray)
	{
		int size = numbersArray.length;
		int i,j,tmp;
		for(i = 1;i<size;i++)
		{
			tmp = numbersArray[i];
			
			for(j=i;j>0 && tmp< numbersArray[j-1]; j--)
			{
				numbersArray[j] = numbersArray[j-1];
			}
			numbersArray[j] = tmp;
		}
		return numbersArray;
	}
}