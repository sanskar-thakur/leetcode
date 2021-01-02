class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        bool result = true;
        for(int i = 0; i < arr.size();){
            bool found = false;
            int val = 0;
            for(int j = 0; j < pieces.size(); j++){
                vector<int>::iterator it;
                it = find(pieces[j].begin(), pieces[j].end(), arr[i]);
                if(it != pieces[j].end()){
                    found = true;
                    val = j;
                    break;
                }                
            }
            
            if(!found)  return false;
            
            for(int k = 0; k < pieces[val].size(); k++){
                if(arr[i] == pieces[val][k]){
                    i++;                        
                }
                else{
                    return false;
                }
            }                  
        }
        return result;
    }
    
    
};
