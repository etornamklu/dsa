package linkedlist.reorder_linked_list;

import linkedlist.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;


        // use the fast and slow pointer technique to find the middle of the linked list
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        // split the linked list into two halves and reverse the second half
        ListNode second = slow.next;
        ListNode prev = slow.next = null; // set the next pointer of the middle node to null to split the linked list into two halves
        
        // reverse the second half of the linked list
        while (second != null) {
            ListNode temp = second.next; // store the next node of the second half in a temporary variable
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode firstTemp = first.next;
            ListNode secondTemp = second.next;
            first.next = second;
            second.next = firstTemp;
            first = firstTemp;
            second = secondTemp;
        }

    }
}
