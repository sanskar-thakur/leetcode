public class Solution {
    public int DominantIndex(int[] nums) {
        if(nums.Length == 0) return -1;
        if(nums.Length == 1) return 0;
        int largest = 0, secondLargest = 0, index = -1;
        for(int i = 0 ; i < nums.Length; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
                index = i;
            }
            else if(nums[i] > secondLargest) secondLargest = nums[i];
        }
        
        return secondLargest * 2 <= largest ? index : -1;
    }
}
