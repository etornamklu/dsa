# Slow And Fast Pointer Algorithms

The slow/fast pointer pattern uses two references that move through the same linked list at different speeds.

- `slow` usually moves `1` node at a time.
- `fast` usually moves `2` nodes at a time.

This is useful because a linked list does not give random access like an array. Instead of using indexes, we let pointer movement reveal structure in the list.

## Core Idea

When two pointers move at different speeds, their relative positions tell us something important:

- If `fast` reaches `null`, we know we touched the end of the list.
- If `fast` catches `slow`, there is a cycle.
- If `fast` moves twice as fast as `slow`, then when `fast` reaches the end, `slow` is around the middle.
- If we keep a fixed gap between `fast` and `slow`, we can find nodes relative to the end of the list.

This pattern gives `O(n)` time and usually `O(1)` extra space.

## 1. Finding The Middle Of A Linked List

This appears in problems like reordering a linked list.

### How it works

- Start `slow` near the head.
- Start `fast` near the head.
- Move `slow` by `1`.
- Move `fast` by `2`.
- When `fast` can no longer move, `slow` is at the middle.

### Why it works

For every `2` steps taken by `fast`, `slow` takes `1`. So `slow` covers only half the distance of `fast`. By the time `fast` finishes the list, `slow` has reached the midpoint.

### Typical code shape

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

### Common use

In `reorder_linked_list`, the middle is needed so the list can be split into:

- first half
- second half

Then the second half is reversed and merged back alternately.

## 2. Detecting A Cycle

This is Floyd's Cycle Detection Algorithm, also called the tortoise and hare algorithm.

### How it works

- `slow` moves `1` step.
- `fast` moves `2` steps.
- If there is no cycle, `fast` eventually becomes `null`.
- If there is a cycle, `fast` keeps looping and eventually lands on the same node as `slow`.

### Why they must meet

Inside a cycle, `fast` gains `1` extra step on `slow` every round because:

- `slow` moves `1`
- `fast` moves `2`

That means the distance between them shrinks modulo the cycle length. Since the cycle is finite, `fast` must eventually catch `slow`.

### Typical code shape

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true;
    }
}

return false;
```

### Important detail

Always check:

```java
fast != null && fast.next != null
```

before doing `fast.next.next`, otherwise you can get a `NullPointerException`.

## 3. Finding The Start Of A Cycle

Your cycle solution also includes the follow-up problem: once `slow` and `fast` meet, find the node where the cycle begins.

### Process

1. First, detect the meeting point inside the cycle.
2. Put one pointer at `head`.
3. Leave the other pointer at the meeting point.
4. Move both one step at a time.
5. The node where they meet again is the start of the cycle.

### Why it works

Suppose:

- distance from `head` to cycle start is `a`
- distance from cycle start to meeting point is `b`
- cycle length is `c`

By the time they meet:

- `slow` has moved `a + b`
- `fast` has moved `2(a + b)`

The extra distance traveled by `fast` must be a whole number of cycle lengths:

```text
2(a + b) - (a + b) = k * c
a + b = k * c
```

Rearranging shows that if one pointer starts at `head` and one starts at the meeting point, moving both one step at a time makes them meet at the cycle entry.

## 4. Removing The Nth Node From The End

This is a variation of the two-pointer idea. The pointers move at the same speed, but we first create a gap between them.

### How it works

- Put `slow` and `fast` at the front.
- Move `fast` ahead by `n` nodes.
- Now the gap between them is exactly `n`.
- Move both pointers one step at a time.
- When `fast` reaches the end, `slow` is right before the node to remove.

### Why it works

Because the gap never changes. If `fast` is always `n` nodes ahead, then when `fast` has `0` nodes left before the end, `slow` has exactly `n` nodes to the end. That places `slow` just before the target node.

### Why a dummy node helps

Using a dummy node avoids special-case logic when the head itself must be deleted.

```java
ListNode dummy = new ListNode(0, head);
ListNode slow = dummy;
ListNode fast = head;
```

Without the dummy node, removing the first real node is more awkward.

## 5. Reordering A Linked List

The reorder problem combines multiple linked-list techniques:

1. Use slow/fast pointers to find the middle.
2. Reverse the second half.
3. Merge the two halves alternately.

The slow/fast part matters because it lets us split the list in one pass without counting nodes first.

## When To Think About This Pattern

Use slow/fast pointers when a linked-list problem asks for:

- the middle node
- cycle detection
- cycle start
- kth or nth node from the end
- splitting a list into two halves
- comparing first and second halves after reversing one side

## Common Mistakes

- Forgetting the `fast != null && fast.next != null` check.
- Starting `fast` at the wrong node and getting the wrong middle for even-length lists.
- Forgetting to break the list when splitting it into two halves.
- Losing nodes during reversal because `next` was not saved first.
- Removing the head without using a dummy node.

## Summary

The slow/fast pointer technique is powerful because it extracts structure from a linked list using only pointer movement.

- Different speeds help find the middle or detect cycles.
- A fixed gap helps locate nodes from the end.
- It is efficient because it avoids extra arrays, maps, or repeated scans.

For linked-list interviews and practice problems, this is one of the most important patterns to recognize quickly.
