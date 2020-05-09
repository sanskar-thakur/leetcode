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
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL) return false;
        
        queue<TreeNode*> qT;
        qT.push(root);
        if(checkDepth(qT,x,y) && checkParent(root,x,y)) return true;
        return false;        
    }
    
    bool checkDepth(queue<TreeNode*> qT, int x, int y){        
        bool result;
        queue<TreeNode*> temp;
        bool xFound = false, yFound = false;
        while(!qT.empty()){
            TreeNode* current = qT.front();
            if(current->val == x) xFound = true;
            else if(current->val == y) yFound = true;
            else{
                if(current->left != NULL)
                    temp.push(current->left);
                if(current->right != NULL)
                    temp.push(current->right);                
            }
            qT.pop();
        }
        
        if(xFound && yFound) return true;
        else if(!xFound && !yFound){
            result = checkDepth(temp, x, y);
            return result;
        }
        return false;
    }
    
    bool checkParent(TreeNode* root, int x, int y){   
        
        if(root->val == x || root->val == y) return false;
        
        int xParent = getParent(root, x);
        int yParent = getParent(root, y);
        
        if(xParent == yParent) return false;
        return true;
    }
    
    int getParent(TreeNode* current, int val){          
        if(current == NULL) return -1;
        
        TreeNode* parent = current;
        int result;
        if((current->left != NULL && current->left->val == val) ||
           (current->right != NULL && current->right->val == val))
        {
            return current->val;
        }        
        else{
            result = getParent(current->left, val);
            if(result == -1)
                result = getParent(current->right, val);            
        }
        return result;
        
    }
};
