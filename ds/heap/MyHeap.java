public class MyHeap{	

	int[] heapArr;
	int heapSize;
	public MyHeap(int size){
		this.heapSize = size;
		this.heapArr = new int[this.heapSize];
		System.out.println("Heap created with size: " + this.heapSize);
	}
	
	public boolean add(int element){
		if(heapArr.length >= heapSize){
			return false;		
		}
		
		return true;
	}
	
	public static void main(String[] args){
		System.out.println("Heap and its operations.");
		MyHeap h = new MyHeap(10);
	}
}
