package javaPrograms;
import java.util.*;

class collections{

	public static void main(String[] args){		
		//List
		System.out.println("List:");
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		Iterator<Integer> it = intList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}		
		
		//Queue
		System.out.println("PQ:");
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("Z");
		pq.add("K");
		pq.add("A");
		System.out.println("Queue comparator:" + pq.comparator());
		Iterator<String> itr = pq.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println("Top element:" + pq.peek());
		pq.poll();
		System.out.println("After updation:");
		itr = pq.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		//Stack
		System.out.println("Stack:");
		Stack<Integer> st = new Stack<Integer>();
		st.push(10);
		st.push(4);
		st.push(6);
		st.push(19);
		st.push(7);
		it = st.iterator();
		while(!st.empty()){
			System.out.println(st.pop());
		}		
	}
}
