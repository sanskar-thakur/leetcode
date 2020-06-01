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
    TreeNode* invertTree(TreeNode* root) {
        invert(root);
        return root;
    }
    
    void invert(TreeNode* curNode){
        //deque<TreeNode*> myQLeft;
        //deque<TreeNode*> myQRight;
        if(curNode == NULL) return;
        
        TreeNode* tempNode = curNode->left;
        curNode->left = curNode->right;
        curNode->right = tempNode;
                
        invert(curNode->left);
        invert(curNode->right);
    }
};
