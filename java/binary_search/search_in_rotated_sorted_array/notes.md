# Search In Rotated Sorted Array

First finds the rotation pivot, then runs ordinary binary search on the only half that can contain the target.

## Approach

- locate the smallest element with pivot search
- use the pivot and right boundary to decide which sorted half to search
- run classic binary search on that half

## Complexity

- Time: `O(log n)`
- Space: `O(1)`

## Related Pattern

- [../rotated_sorted_array_search.md](../rotated_sorted_array_search.md)
- [../classic_binary_search.md](../classic_binary_search.md)
