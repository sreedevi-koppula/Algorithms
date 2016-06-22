package sorting;

import java.util.Scanner;

public class MergeSort {

	//Time Complexity:				//Space Complexity:
	//Best = O(n log(n))			// O(n)
	//Average = O(n log(n))
	//Worst = O(n log(n))
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] array = in.nextLine().split(" ");
		in.close();
		int[] numArray = new int[array.length];
		int[] sorted = new int[array.length];
		
		for(int i=0;i<array.length;i++)
			numArray[i] = Integer.parseInt(array[i]);
		
		display(numArray);	
		mergeSort(numArray,0,numArray.length-1,sorted);
		display(numArray);			
	}
	
	public static void display(int[] arr){
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
	
	public static void mergeSort(int[] arr,int low,int high,int[] sorted){
		
		if(low != high){
			int mid = (low+high)/2;
			mergeSort(arr,low,mid,sorted);
			mergeSort(arr,mid+1,high,sorted);
			merge(arr,low,mid+1,high,sorted);
		} else
			return;
	}
	
	private static void merge(int[] arr,int low,int mid,int high,int[] sorted){
		int i=0;
		int medium = mid-1;
		int lower = low;
		while(low<=medium && mid<=high){
			if(arr[low] < arr[mid])
				sorted[i++] = arr[low++];
			else 
				sorted[i++] = arr[mid++];
		}
		
		while(low<=medium)
			sorted[i++] = arr[low++];
		
		while(mid<=high)
			sorted[i++] = arr[mid++];
		
		for(int j=0;j<high-lower+1;j++)
			arr[lower+j] = sorted[j];
	}

}
