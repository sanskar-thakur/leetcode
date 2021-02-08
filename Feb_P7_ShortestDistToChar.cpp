class Solution {    
public:
    vector<int> shortestToChar(string s, char c) {
        vector<int> ans;
        vector<int> indx;
        ans.resize(s.length(), INT_MAX);
        for(int i = 0; i < s.length(); i++){
            if(s[i] == c){
                ans[i] = 0;
                indx.push_back(i);
            }
        }
        for(int i = 0; i < indx.size(); i++){
            int leftdist = 1;
            int rightdist = 1;
            int left = indx[i] - 1;
            int right = indx[i] + 1;
            while(left >= 0){
                if(ans[left] > leftdist) ans[left] = leftdist;
                left--;
                leftdist++;
            }
            while(right < s.length()){
                if(ans[right] > rightdist) ans[right] = rightdist;
                right++;
                rightdist++;
            }
        }
        return ans;
    }
};
