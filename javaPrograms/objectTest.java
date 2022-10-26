import java.util.*;

class objectTest{
	static class obj{
		int x;
		obj(int val){ this.x = val;}
	}

	public static void main(String[] args){
		obj myObj = new obj(10);
		System.out.println("Object : " + myObj.x);
		obj refObj = myObj;
		System.out.println("Object : " + refObj.x);
		System.out.println("Ref Object : " + refObj);
		myObj = null;
		System.out.println("Object : " + myObj + " Ref : " + refObj);
	}
}
