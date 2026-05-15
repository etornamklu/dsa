# Linked List Cycle Detection

Uses slow and fast pointers to detect whether a cycle exists, and can also locate the cycle entry.

## Approach

- move `slow` one step at a time
- move `fast` two steps at a time
- if they ever meet, a cycle exists
- to find the cycle start, move one pointer to `head` and advance both one step until they meet again

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../slow_and_fast_pointers.md](../slow_and_fast_pointers.md)
