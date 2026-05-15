# Dummy Node Technique

A dummy node is an extra node placed before the real head to simplify linked-list edge cases.

## Core Idea

Instead of treating head updates as a special case, anchor the list behind a stable node.

```java
ListNode dummy = new ListNode(0, head);
```

## When It Appears Here

- `remove_nth_node_from_end_of_list`
- `merge_two_sorted_linked_list`
- `lru_cache` uses dummy boundary nodes in the doubly linked list

## Why It Helps

Without a dummy node, removing or inserting at the front often needs special handling.

With a dummy node:

- the node before the real head always exists
- merge and splice logic becomes uniform
- pointer code becomes safer and shorter

## Common Uses

### Removal near the head

```java
ListNode dummy = new ListNode(0, head);
ListNode slow = dummy;
```

### Building a merged list

```java
ListNode dummy = new ListNode(0);
ListNode tail = dummy;
```

### Linked list boundaries in caches

Two dummy nodes can represent:

- left boundary
- right boundary

That removes null checks during insert and remove.

## Recognition Signals

Use this when:

- you may delete the first real node
- you are building a new list incrementally
- you want simpler insertion and deletion code

## Common Mistakes

- Returning `dummy` instead of `dummy.next`.
- Forgetting that the dummy is not part of the real answer.
- Mixing dummy-based logic with direct-head logic and creating inconsistent pointer updates.

## Complexity

The dummy node does not change asymptotic complexity. It reduces branching and edge-case code.
