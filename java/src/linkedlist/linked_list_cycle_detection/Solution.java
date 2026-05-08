package linkedlist.linked_list_cycle_detection;

import linkedlist.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false; // if there is no node, there can't be a cycle

        ListNode slow = head; // slow pointer moves one step at a time
        ListNode fast = head.next; // fast pointer moves two steps at a time

        // if there is a cycle, the fast pointer will eventually meet the slow pointer
        while (slow != fast) { //
            if (fast == null || fast.next == null) return false; // if fast reaches the end of the list, there is no cycle
            slow = slow.next; // move slow pointer one step
            fast = fast.next.next; // move fast pointer two steps
        }

        return true;
    }

    public int detectCycle(ListNode head) {
        if (head == null) return -1;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode start = head;
                int pos = 0;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                    pos++;
                }
                return pos;
            }
        }

        return -1;
    }
    
}
