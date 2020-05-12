class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {        
        int color = image[sr][sc];
        if (color != newColor) fillVector(image, sr, sc, color, newColor);
        return image;        
    }
    
    void fillVector(vector<vector<int>>& image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1) fillVector(image, sr-1, sc, color, newColor);
            if (sc >= 1) fillVector(image, sr, sc-1, color, newColor);
            if (sr+1 < image.size()) fillVector(image, sr+1, sc, color, newColor);
            if (sc+1 < image[0].size()) fillVector(image, sr, sc+1, color, newColor);
        }
    }
};
