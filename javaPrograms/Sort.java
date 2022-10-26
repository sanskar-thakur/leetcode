import java.util.*;
import java.lang.Math;

class Sort{

	static int[] input;

	public static void printArray(int[] arr){
		for(int ele : arr){
			System.out.println(ele);
		}
	}
	
	public static void merge(int l, int m, int r){

		int arrSize = r - l + 1;
		int[] temp = new int[arrSize];
		int i = l, j = m+1;
		int k = 0;
		while(k < arrSize)
		{
			if(i <= m && j <= r)
			{
				if(input[i] < input[j]) temp[k++] = input[i++];
				else temp[k++] = input[j++];			
			}						
		}
		while(i <= m) temp[k++] = input[i++];
		while(j <= r) temp[k++] = input[j++];
		
		for(i = l, k = 0; i <= r && k < arrSize; ){
			input[i++] = temp[k++];
		}
	}
	
	public static void mergeSort(int left, int right){
		if(left < right){
			int mid = (int)Math.floor((double)((left+right)/2));
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left,mid,right);
		}
	}

	public static int partition(int l, int r){
		int pivot = input[r];
		int i = l - 1;
		for(int j = l; j < r; j++){
			if(input[j] <= pivot){
				i++;
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
			}
		}
		int temp = input[r];
		input[r] = input[i+1];
		input[i+1] = temp;
		return i + 1;
	}

	public static void quickSort(int left, int right){
		if(left < right){
			int q = partition(left, right);
			quickSort(left,q-1);
			quickSort(q+1,right);
		}
	}

	public static void main(String[] args){
		System.out.println("Sorting algorithms.");
		input = new int[]{44,52,81,70,63,105,9,32,12,10};
		//input = new int[]{1,1,1};
		System.out.println("Input array:");
		printArray(input);
		//mergeSort(0, input.length - 1);
		quickSort(0, input.length - 1);
		System.out.println("Sorted array:");
		printArray(input);
	}

}
