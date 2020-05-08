class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int,int> numCount;
        for(int i=0; i<nums.size(); i++){
            if(numCount.count(nums[i]) > 0){
                numCount[nums[i]]++;
            }
            else
                numCount[nums[i]] = 1;
        }
        int maxCount = 0;
        int majNum;
        map<int,int>::iterator iter;
        for(iter = numCount.begin(); iter != numCount.end(); iter++){
            if(iter->second > maxCount){
                maxCount = iter->second;
                majNum = iter->first;
            }
        }
        return majNum;
    }
};
