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
    TreeNode* trimBST(TreeNode* root, int low, int high) {        
        if(root == NULL) return NULL;
        TreeNode* ans = root;
        if(root->val >= low && root->val <= high){
            ans->left = trimBST(root->left, low, high);
            ans-> right = trimBST(root->right, low, high);
        }
        else{
            if(root->val < low){
                return trimBST(root->right, low, high);
            }
            else if(root->val > high){
                return trimBST(root->left, low, high);
            }
        }
        return ans;
    }
};
