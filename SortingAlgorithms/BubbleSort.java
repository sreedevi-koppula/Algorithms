package sorting;

import java.util.Scanner;

public class BubbleSort {

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
		
		int[] sortedNumbersArray = bubbleSort(numbersArray);
		for(int i:sortedNumbersArray)
		{
			System.out.print(i+" ");
		}
	}

	
	public static int[] bubbleSort(int[] numbersArray)
	{
		int i,j,tmp;
		int size = numbersArray.length;
		for(i = 0;i<size-1;i++)
		{
			for(j = 0;j<size-1-i;j++)
			{
				if(numbersArray[j] > numbersArray[j+1])
				{
					tmp = numbersArray[j+1];
					numbersArray[j+1] = numbersArray[j];
					numbersArray[j] = tmp;
				}
			}
		}
		return numbersArray;
	}

}
