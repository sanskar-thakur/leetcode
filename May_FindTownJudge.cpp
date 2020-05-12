class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        if(N == 1) return N;
        map<int,vector<int>> myMap;
        for(int i = 0; i < trust.size(); i++){
            if(myMap.count(trust[i][0]) > 0){
                myMap[trust[i][0]].push_back(trust[i][1]);
            }
            else{
                vector<int> temp;
                temp.push_back(trust[i][1]);
                myMap[trust[i][0]] = temp;
            }
        }
        //condition 1
        vector<int> nums;
        for(int i = 1; i <= N; i++){
            if(!(myMap.count(i) > 0)) nums.push_back(i);            
        }
                
        //condition 2
        vector<int>::iterator iter;
        map<int,vector<int>>::iterator it;
        int ans = -1;
        if(nums.size() > 1) return ans;
        for(iter = nums.begin(); iter != nums.end(); iter++){
            bool found = true;
            for(it = myMap.begin(); it != myMap.end(); it++){
                vector<int> temp = it->second;                
                if(std::find(temp.begin(),temp.end(),*iter) != temp.end()){
                    continue;
                }            
                else{
                    found = false;
                    break;
                }
            }
            if(found){
                ans = *iter;
                break;
            }
        }
        return ans;
    }
};
