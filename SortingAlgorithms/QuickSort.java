package sorting;

import java.util.Scanner;

public class QuickSort {
	//Time Complexity:				//Space Complexity:
	//Best = O(n log(n))			//Worst: O(log(n))
	//Average = O(n log(n))
	//Worst = O(n^2)
	
	//In this implementation of quicksort, the last element in the array is chosen as pivot
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] array = in.nextLine().split(" ");
		in.close();
		int[] numArray = new int[array.length];
		for(int i=0;i<array.length;i++)
			numArray[i] = Integer.parseInt(array[i]);
		display(numArray);
		quickSort(numArray,0,array.length-1);
		display(numArray);
	}
	
	public static void quickSort(int[] arr,int start,int end){
		if(end<start)
			return;
		else{
			int pivotPosition = partition(arr,start,end);
			quickSort(arr,start,pivotPosition-1);
			quickSort(arr,pivotPosition+1,end);
		}	
	}

	private static int partition(int[] arr,int start, int end){
		int pivot = arr[end];
		int lowest = start-1;
		int highest = end;
		while(true){
			while(arr[++lowest]<pivot)
				;
			while(arr[--highest]>pivot && highest>0)
				;
			if(lowest<highest)
				swap(arr,lowest,highest);
			else
				break;
		}
		swap(arr,lowest,end);
		return lowest;
	}
	
	private static void swap(int[] arr,int a1,int a2){
		int temp = arr[a1];
		arr[a1] = arr[a2];
		arr[a2] = temp;
	}
	
	public static void display(int[] arr){
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
