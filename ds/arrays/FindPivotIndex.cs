public class Solution {
    public int PivotIndex(int[] nums) {
        if(nums.Length == 0) return -1;
        
        if(nums.Length == 1) return 0;
        
        //Calculate sum
        int totalSum = 0;
        for(int i = 0; i < nums.Length; i++){
            totalSum += nums[i];
        }
        //Traverse and get left sum/right sum
        int leftSum = 0;
        int rightSum = totalSum;
        for(int i = 0; i < nums.Length; i++){                        
            rightSum = rightSum - nums[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
