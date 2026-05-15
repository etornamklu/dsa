# Find Minimum In Rotated Sorted Array

Finds the pivot, which is the smallest element, using binary search on the rotated structure.

## Approach

- compare the middle element with the right boundary
- if `nums[m] < nums[r]`, the minimum is at `m` or to the left
- otherwise the minimum is to the right
- stop when `l == r`

## Complexity

- Time: `O(log n)`
- Space: `O(1)`

## Related Pattern

- [../rotated_sorted_array_search.md](../rotated_sorted_array_search.md)
