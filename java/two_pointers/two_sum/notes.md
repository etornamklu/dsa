# Two Sum II Input Array Is Sorted

Uses two pointers on the sorted array to find the required pair in linear time.

## Approach

- start one pointer at the left end and one at the right end
- if the sum is too small, move the left pointer right
- if the sum is too large, move the right pointer left
- stop when the target is found

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../opposite_direction_two_pointers.md](../opposite_direction_two_pointers.md)
