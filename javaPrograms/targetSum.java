import java.util.*;

class TargetSum{
	private static int count = 0;

	private static int negate(int x) { return x*(-1); }

	private static int sumRec(int[] nums, int i, int target){
		if(i >= nums.length) return 0;
		int sum = 0;
		Deque<Integer> q = new ArrayDeque<>();
		q.push(nums[i]);
		q.push(negate(nums[i]));
		while(!q.isEmpty()){
			sum = q.pop() + sumRec(nums, i+1, target);
			if(sum == target) count++;
		}		
		return sum;
	}

	public static void main(String[] args){
		int[] num = {1,1,1,1,1};
		sumRec(num,0,3);
		System.out.println("Count: " + count);
	}
}
