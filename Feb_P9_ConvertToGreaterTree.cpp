/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    int globalVal = 0;
    void Solve(TreeNode* node){        
        if(node->right) Solve(node->right);                
        globalVal+=node->val;
        node->val=globalVal;                
        if(node->left) Solve(node->left);
    }
    
    TreeNode* convertBST(TreeNode* root) {        
        if(root == NULL) return root;                        
        Solve(root);
        return root;
    }
};
