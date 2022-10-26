import java.util.*;
class QueueStack{
	public static void main(String[] args){
		createQueue();
		createStack();
	}
	
	public static void createQueue(){
		MyQueue que = new MyQueue();
		que.print();
		System.out.println(que.pop());
		que.push(1);
		que.push(2);
		que.push(3);
		que.print();
		System.out.println(que.pop());
		que.push(4);
		que.push(5);
		que.print();
	}
	
	public static void createStack(){
		MyStack stck = new MyStack();
		stck.print();
		stck.pop();
		stck.push(1);
		stck.push(2);
		stck.push(3);
		stck.print();
		stck.pop();
		stck.push(4);
		stck.push(5);
		stck.print();
	}
}

class MyQueue{
	List<Integer> qList = new ArrayList<Integer>();
	public Integer pop(){
		int last = -1;
		if(qList.size() > 0){
			last = qList.get(0);
			qList.remove(0);
		}
		return last;
	}
	
	public void push(Integer ele){
		qList.add(ele);
	}
	
	public Integer front(){
		if(qList.size() > 0){
			return qList.get(0);
		}
		return -1;
	}
	
	public Integer end(){
		if(qList.size() > 0){
			return qList.get(qList.size() - 1);
		}
		return -1;
	}
	
	public void print(){
		System.out.println(qList);
	}
}

class MyStack{
	List<Integer> sList = new ArrayList<Integer>();
	public void pop(){
		if(sList.size() > 0){			
			sList.remove(sList.size() - 1);
		}
	}
	
	public void push(Integer ele){
		sList.add(ele);
	}
	
	public Integer top(){
		if(sList.size() > 0){
			return sList.get(sList.size() - 1);
		}
		return -1;
	}		
	
	public void print(){
		System.out.println(sList);
	}
}
