import java.util.*;

class SynchronizedThread{	

	public static void main(String[] args){
		System.out.println("Running synchronised threads.");		
		Data d = new Data();
		Write w = new Write("WriteThread", d);
		Read r = new Read("ReadThread", d);
		try{
			r.t.join();
			w.t.join();
		} catch (InterruptedException e) {
		System.out.println("Main thread Interrupted");}
		
		System.out.println("Main thread exiting.");
	}
}

class Data{
	protected List<Integer> list;
	private int ele = 0;
	boolean valueSet = false;
	
	Data(){
		this.list = new ArrayList<>();
	}
	
	synchronized void get() {
		while(!valueSet){
			try {
			wait();
			} catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
			}
		}	
		if(list.size() > 0) System.out.println("Read : " + list.get(list.size() - 1));		
		valueSet = false;
		notify();	
	}
	
	synchronized void put() {
		while(valueSet){
			try {
			wait();
			} catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
			}
		}
		if(ele < 10){
				valueSet = true;
				System.out.println("Write : " + ele);
				list.add(ele++);
				notify();
		}
	}
}

class Read implements Runnable{

	Thread t;
	String name;
	Data data;
	boolean flag = true;
	
	Read(String threadName, Data d){
		this.name = threadName;
		this.data = d;
		t = new Thread(this, threadName);
		t.start();
	}
	
	public void run(){
		System.out.println("Running read thread.");
		synchronized(data){					
				while(true){
					data.get();
				}								
		}		
	}			
}

class Write implements Runnable{

	Thread t;
	String name;
	Data data;
	int ele = 0;
	boolean flag = false;
	
	Write(String threadName, Data d){
		this.name = threadName;
		this.data = d;
		t = new Thread(this, threadName);
		t.start();
	}
	
	public void run(){
		System.out.println("Running write thread.");
		synchronized(data){					
				while(true){
					data.put();
				}								
		}
	}			
}
