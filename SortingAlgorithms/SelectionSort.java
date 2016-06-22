package sorting;

import java.util.Scanner;

public class SelectionSort {
	
	//Time Complexity:				//Space Complexity:
	//Best = O(n^2)					// O(1)
	//Average = O(n^2)
	//Worst = O(n^2)
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String givenNumbers = in.nextLine();
		in.close();
		String[] stringArray = givenNumbers.split(" ");
		int[] numbersArray = new int[(stringArray.length)];
		for(int i = 0;i<stringArray.length;i++)
		{
			numbersArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		selectionSort(numbersArray);
		
	}

	public static void selectionSort(int[] numbersArray)
	{
		int sizeOfArray = numbersArray.length;
		int i,j,tmp,min;
		
		for(i=0;i<sizeOfArray-1;i++)
		{
			min = i;
			tmp = numbersArray[i];
			
			for(j=i;j<sizeOfArray-1;j++)
			{
				if(numbersArray[j+1]<numbersArray[min])
					min = j+1;
			}
			numbersArray[i] = numbersArray[min];
			numbersArray[min] = tmp;
			System.out.print(numbersArray[i]+" ");
		}
		
		System.out.println(numbersArray[i]);
	}

}
