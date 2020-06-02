/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        if(node == NULL || node->next == NULL) return;
        ListNode* prevNode = node;
        while(node->next != NULL){
            node->val = node->next->val;
            prevNode = node;
            node = node->next;
        }
        prevNode->next = NULL;
    }
};
