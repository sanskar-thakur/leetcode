class Solution {
public:
    int firstUniqChar(string s) {
        std::map<char,int> myMap;
        std::map<char,int>::iterator iter;
        for(int i = 0; i < s.length(); i++){
            if(myMap.count(s[i]) > 0){
                myMap[s[i]] = -1;
            }
            else{
                myMap[s[i]] = i;
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(myMap[s[i]] != -1){
                return i;
            }
        }
        return -1;
    }
};
