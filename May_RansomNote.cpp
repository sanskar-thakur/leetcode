class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        map<char,int> inputMap;
        map<char, int> targetMap;
        
        for(int i = 0; i < ransomNote.length(); i++){
            if(inputMap.count(ransomNote[i]) > 0){
                inputMap[ransomNote[i]]++;
            }
            else{
                inputMap[ransomNote[i]] = 1;
            }
        }
        for(int i = 0; i < magazine.length(); i++){
            if(targetMap.count(magazine[i]) > 0){
                targetMap[magazine[i]]++;
            }
            else{
                targetMap[magazine[i]] = 1;
            }
        }
        
        map<char,int>::iterator iter;
        bool result = true;
        for(iter = inputMap.begin(); iter != inputMap.end(); iter++){
            if(targetMap.count(iter->first) > 0 && targetMap[iter->first] >= iter->second) continue;
            else{
                result = false;
                break;
            }
        }
        return result;
        
    }
};
