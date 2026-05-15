package linkedlist.remove_nth_node_from_end_of_list;

import linkedlist.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create a dummy node that points to the head of the linked list because we create a gap of n nodes between the slow and fast pointers, the slow pointer will be pointing to the node before the node to be removed when the fast pointer reaches the end of the linked list, 
        // so we need to create a dummy node to handle the case when the head of the linked list is removed 
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;

        // create a gap of n nodes between the slow and fast pointers
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
    
}
