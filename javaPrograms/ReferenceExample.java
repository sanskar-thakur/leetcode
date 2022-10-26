import java.util.*;

class ReferenceExample{
	public static void main(String[] args){
		System.out.println("Starting Reference program");
		List<Integer> first = new ArrayList<>();
		first.add(1);		
		System.out.println("First list : " + first);
		List<Integer> second = first;
		System.out.println("Second list : " + second);
		second.add(2);
		System.out.println("First list : " + first);
		System.out.println("Second list : " + second);
	}
}
