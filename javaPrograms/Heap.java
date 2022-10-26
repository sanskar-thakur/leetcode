import java.util.*;
import java.lang.Math;
class Test{

static int inputSize;
static int[] input;
static int[] maxHeap;

public static void printArray(int[] arr){
	for(int ele : arr){
		System.out.println(ele);
	}
}

public static void heapify(int[] target, int element, int index){
	int largest = index;
	int left = 2 * index + 1;
	int right = 2 * index + 2;
	if(left < target.length && target[left] > element) largest = left;
	if(right < target.length && target[right] > target[largest]) largest = right;
	if(largest != index)
	{		
		target[index] = target[largest];
		target[largest] = element;
		heapify(target, target[largest], largest);		
	}	
}

public static void constructMaxHeap(int[] input){
	inputSize = input.length;
	maxHeap = input.clone();
	int start = (int)Math.floor((double)inputSize/2);
	//printArray(maxHeap);
	
	//Heapify
	for(int i = start - 1; i >= 0; i--){
		maxHeap[i] = input[i];
		heapify(maxHeap, maxHeap[i], i);
	}	
}

public static void heapSort(){
	int[] output = new int[inputSize];
	int index = inputSize - 1;
	int[] curHeap = maxHeap.clone();
	
	while(index >= 0)
	{
		//pop top element from curHeap
		int top = curHeap[0];
		int last = curHeap[index];
		curHeap[0] = last;		
		//Insert from last into output array
		output[index] = top;
		
		//heapify new heap
		if(index != 0){
			curHeap = Arrays.copyOf(curHeap, index);
			heapify(curHeap, curHeap[0], 0);	
		}						
		
		index--;
	}
	
	System.out.println("Sorted array:");
	printArray(output);	

}



public static void main(String[] args){
	System.out.println("Program to construct max heap.");
	input = new int[]{44,52,81,70,63,105,9,32,12,10};
	System.out.println("Input array:");
	printArray(input);
	constructMaxHeap(input);	
	System.out.println("Max Heap:");
	printArray(maxHeap);
	heapSort();
}
   
}
