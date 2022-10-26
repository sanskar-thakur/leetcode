

class ThreadExample{	

	public static void main(String[] args){
		System.out.println("Starting thread program.");
		NewThread thObj1 = new NewThread("First");
		NewThread thObj2 = new NewThread("Second");
		NewThread thObj3 = new NewThread("Third");
		System.out.println("Thread First is alive: " + thObj1.t.isAlive());
		System.out.println("Thread Second is alive: " + thObj2.t.isAlive());
		System.out.println("Thread Third is alive: " + thObj3.t.isAlive());
		try {
			System.out.println("Waiting for threads to finish.");
			thObj1.t.join();
			thObj2.t.join();
			thObj3.t.join();
		} catch (InterruptedException e) {
		System.out.println("Main thread Interrupted");}
		
		System.out.println("Thread First is alive: " + thObj1.t.isAlive());
		System.out.println("Thread Second is alive: " + thObj2.t.isAlive());
		System.out.println("Thread Third is alive: " + thObj3.t.isAlive());
		System.out.println("Main thread exiting.");
	}
}

class NewThread implements Runnable{
		Thread t;
		String name; // name of thread
		
		NewThread(String threadName){
			this.name = threadName;
			this.t = new Thread(this, threadName);
			t.start();
		}
		
		public void run(){
			try{
				for(int i = 0; i < 5; i++){
					System.out.println(name + ": " + i);
					Thread.sleep(500);
				}
			} catch(InterruptedException ex){
				System.out.println("Thread " + name + "interrupted.");
			}
		}
	}
