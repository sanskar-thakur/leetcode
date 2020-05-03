class Solution {
public:
    int numJewelsInStones(string J, string S) {
        std::map<char,int> jewelsMap;
        for(int i = 0; i < J.length(); i++){
            jewelsMap[J[i]] = i;
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(jewelsMap.count(S[i]) > 0) count++;
        }
        return count;
    }
};
