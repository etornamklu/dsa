# Reverse Linked List

Reverses the list in place by rewiring each `next` pointer exactly once.

## Approach

- track `prev`, `curr`, and saved `next`
- reverse the current pointer
- advance all pointers until the list ends

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../in_place_linked_list_reversal.md](../in_place_linked_list_reversal.md)
