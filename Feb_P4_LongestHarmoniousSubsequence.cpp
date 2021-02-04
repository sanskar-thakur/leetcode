class Solution {
public:
    int findLHS(vector<int>& nums) {
        int ans = 0;
        map<int, int> freqMap; 
        for(int i = 0; i < nums.size(); i++){
            if(freqMap.find(nums[i]) != freqMap.end()) freqMap[nums[i]]++;
            else freqMap[nums[i]] = 1;
        }
        map<int, int>:: iterator itr = freqMap.begin();    
        map<int, int>:: iterator prev = freqMap.begin();
        itr++;      
        int max = -1;
        for (; itr != freqMap.end(); itr++,prev++) 
        {
            if(itr->first - prev->first == 1){
                int count = itr->second + prev->second;
                if(max < count){
                    max = count;
                    ans = max;
                }
            }                
        }
        return ans;
    }    
};
