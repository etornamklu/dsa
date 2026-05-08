package linkedlist.reverse_linked_list;

import linkedlist.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head){
        ListNode prev = null;  // set prev to null, as the new tail of the reversed list will point to null
        ListNode curr = head; // start with the head of the original list

        while (curr != null) {
            ListNode temp = curr.next; // store the next node before changing the current node's next pointer
            curr.next = prev; // reverse the current node's pointer to point to the previous node
            prev = curr; // move prev to the current node, as it will become the new head of the reversed list
            curr = temp; // move to the next node in the original list, which we stored in temp
        }
        return prev; // at the end of the loop, prev will be pointing to the new head of the reversed list
    }
}
