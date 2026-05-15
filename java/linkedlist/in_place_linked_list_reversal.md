# In-Place Linked List Reversal

This is the core pointer-rewiring technique behind many linked-list problems.

## Core Idea

Walk through the list once and reverse each `next` pointer as you go.

## When It Appears Here

- `reverse_linked_list`
- `reorder_linked_list` for reversing the second half

## Pointer Roles

- `prev` points to the already reversed part
- `curr` points to the current node being processed
- `next` temporarily saves the original next node

## Typical Shape

```java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}

return prev;
```

## Why The Temporary Variable Matters

Once you do:

```java
curr.next = prev;
```

the original forward link is gone. If you did not save it first, you lose the rest of the list.

## Recognition Signals

Use this when:

- you need a list reversed
- you need to process the second half backward
- you want `O(1)` extra space

## Common Mistakes

- Forgetting to save `curr.next` before rewiring.
- Returning `curr` instead of `prev`.
- Accidentally creating a cycle by reusing old pointers incorrectly.

## Complexity

- Time: `O(n)`
- Space: `O(1)`
