package javaPrograms;
import java.util.*;
class rotate{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7};
		int k = 3;
		int temp, prev;
		for(int j = 0; j < k ; j++)
		{
			prev = arr[arr.length - 1];
			for(int i = 0; i < arr.length; i++){
				temp = arr[i];
				arr[i] = prev;
				prev = temp;
			}
		}		
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
}
