import java.util.*;
import java.lang.Math;

class Kth_largest{
	
	private static int heapSize;	
	private static int[] maxHeap;
	private static int[] sortedArray;
		
	public static void printArray(int[] arr){
		System.out.print("[ ");
		for(int ele : arr){
			System.out.print(ele + " ");
		}
		System.out.println("]");
	}
	
	public static void heapify(int[] input, int ele, int index){
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int size = input.length;
		/*System.out.println("Element :" + ele);
		System.out.println("Size :" + size);
		System.out.println(largest + " " + left + " " + right + " ");*/
		if(left < size && input[left] > ele) largest = left;
		if(right < size && input[right] > input[largest]) largest = right;
		if(largest != index){
			int temp = input[index];
			input[index] = input[largest];
			input[largest] = temp;
			heapify(input, input[largest], largest);
		}
	}
	
	public static void constructMaxHeap(int[] input){
		maxHeap = input.clone();
		//printArray(maxHeap);
		int uIndex = (int)Math.floor(input.length/2);	

		while(uIndex >= 0){
			heapify(maxHeap, maxHeap[uIndex], uIndex);
			uIndex--;
		}
		System.out.println("Max Heap:");
		printArray(maxHeap);
	}
	
	public static void heapSort(int[] input){
		int[] curHeap = input.clone();
		int size = curHeap.length;
		sortedArray = new int[size];
		if(size > 0){
			int index =  size - 1;						
			while(index >= 0){
				int top = curHeap[0];
				sortedArray[index] = top;
				curHeap[0] = curHeap[index];
				if(index > 0){
					curHeap = Arrays.copyOf(curHeap, index);
					heapify(curHeap, curHeap[0], 0);					
				}				
				index--;
			}
		}
	}
	
	public static int kthLargest(int[] input, int k){
		if(k < 0) return -1;
		int size = input.length;
		if(size-k >= 0){
			return input[size-k];
		}
		return -1;
	}
	
	public static int parent(int i){
		return (int)Math.floor(i/2);
	}
	
	public static void updateHeap(int[] input, int index){
		if(index < input.length){		
			while(index > 0 && input[index] > input[parent(index)]){
				int temp = input[index];
				input[index] = input[parent(index)];
				input[parent(index)] = temp;
				index = parent(index);
			}
		}
	}
	
	public static void addElementToHeap(int[] input, int ele){
		int size = input.length;
		int[] newArr = Arrays.copyOf(input, size + 1);
		int newSize = newArr.length;

		newArr[newSize - 1] = ele;		
		updateHeap(newArr, newSize - 1);		
		maxHeap = newArr;
	}	
	

	public static void main(String[] args){
		System.out.println("kth largest using heap");
		int[] input = new int[]{43,35,12,3,59,80,27};
		System.out.println("Input array:");
		printArray(input);
		constructMaxHeap(input);	
		heapSort(maxHeap);
		System.out.println("Sorted array:");
		printArray(sortedArray);
		System.out.print("Kth largest: ");
		System.out.println(kthLargest(sortedArray, 7));
		addElementToHeap(maxHeap, 22);
		heapSort(maxHeap);
		System.out.println("Sorted array:");
		printArray(sortedArray);
	}

}
