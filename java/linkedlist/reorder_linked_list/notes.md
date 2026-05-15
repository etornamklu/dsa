# Reorder Linked List

This solution combines three linked-list techniques: find the middle, reverse the second half, then merge both halves alternately.

## Approach

- use slow and fast pointers to find the middle
- split the list into two halves
- reverse the second half in place
- merge nodes from the first and reversed second halves one by one

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../slow_and_fast_pointers.md](../slow_and_fast_pointers.md)
- [../in_place_linked_list_reversal.md](../in_place_linked_list_reversal.md)
