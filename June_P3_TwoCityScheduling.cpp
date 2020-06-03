class Solution {
public:    
    int Mod(int value){
        return value >= 0 ? value : (value * (-1));
    }
    
    int Min(int x, int y){
        return x <= y ? x : y;
    }
    
    void sortCostFunc(vector<vector<int>>& cost){        
        int size = cost.size();
        for(int i = 0; i < size; i++){            
            for(int j = i+1; j < size; j++){
                int costM = Mod(cost[i][1] - cost[i][0]);
                int costN = Mod(cost[j][1] - cost[j][0]);
                if(costN > costM){
                    int temp1 = cost[i][0];
                    int temp2 = cost[i][1];
                    cost[i][0] = cost[j][0];
                    cost[i][1] = cost[j][1];
                    cost[j][0] = temp1;
                    cost[j][1] = temp2;
                }
            }
        }
    }
    
    int calculateMinCost(vector<vector<int>>& costs){
        int result = 0;
        
        int countA = 0, countB = 0, i = 0;
        int size = costs.size();
        for(; i < size; i++){
            int val = Min(costs[i][0],costs[i][1]);
            result += val;
            if(val == costs[i][0]) countA++;            
            else countB++;
            if(countA == size/2 || countB == size/2) break;
        }
        
        if(countA == size/2){
            for(int j = i+1; j < size; j++){
                result += costs[j][1];
            }
        }        
        else if(countB == size/2){
            for(int j = i+1; j < size; j++){
                result += costs[j][0];
            }
        }
        
        return result;
    }
    
    int twoCitySchedCost(vector<vector<int>>& costs) {        
        sortCostFunc(costs);
        return calculateMinCost(costs);                        
    }        
};
