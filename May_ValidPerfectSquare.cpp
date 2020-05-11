class Solution {
public:
    bool isPerfectSquare(int num) {        
        unsigned int i;
        for(i = 1; i * i <= num; i++){
            if(i * i == num) return true;
        }   
        return false;
    }
};
