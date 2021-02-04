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
    bool hasCycle(ListNode *head) {
        if(head == NULL || head->next == NULL) return false;
        bool result = false;
        ListNode* curPtr = head;        
        ListNode* fastPtr = head;
        while(fastPtr->next != NULL){
            curPtr = curPtr->next;
            fastPtr = fastPtr->next->next;
            if(curPtr == fastPtr){
                result = true;
                break;
            }
            if(fastPtr == NULL || fastPtr->next == NULL){
                result = false;
                break;
            }                            
        }
        return result;
    }
};
