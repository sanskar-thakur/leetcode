// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int start = 1;
        int end = n;        
        if(isBadVersion(start) && isBadVersion(end)) return start;
        if(isBadVersion(end) && !isBadVersion(end - 1)) return end;
        while(isBadVersion(end) && end > 0){
            end = (end/2);
        }          
        if(isBadVersion(end) && !isBadVersion(end - 1)) return end;
        start = end;
        end = n;
        while(!isBadVersion(start) && (start != end - 1)){
            start = start + (end - start)/2;
        }        
        while(isBadVersion(start)){
            start--;
        }
        return start + 1;
    }
};
