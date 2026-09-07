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
        ListNode *temp = head;
        ListNode *ptemp = head;
        while(ptemp != NULL && ptemp->next != NULL){
            temp = temp->next;
            ptemp = ptemp->next->next;
            if(temp == ptemp){
                return true;
            }
        }
        return false;
    }
};