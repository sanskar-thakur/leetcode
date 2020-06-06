class Solution {
public:
    Solution(vector<int>& w) {
        int size{(int)w.size()};
        acc = vector<int>(size+1, 0);
        for(int i{1}; i <= size; ++i) acc[i] = w[i-1] + acc[i-1];
        sum = acc[size];
    }
    
    int pickIndex() {
        int v = rand() % sum;
        auto it = upper_bound(acc.begin(), acc.end(), v);
        return std::distance(acc.begin(), it-1);
    }
	
    std::vector<int> acc;
    int sum;
};
