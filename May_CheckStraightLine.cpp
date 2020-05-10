class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        if(coordinates.size() == 2) return true;
            
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for(int i = 2; i < coordinates.size(); i++){
            int ar = x1 * (y2 - coordinates[i][1]) +
                     x2 * (coordinates[i][1] - y1) +
                     coordinates[i][0] * (y1 - y2);

            if(ar != 0){
                return false;
            }
        }
        return true;  
    }
};
