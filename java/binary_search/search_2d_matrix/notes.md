# Search 2D Matrix

Uses the top-right corner to eliminate one row or one column on each comparison.

## Approach

- start at the top-right cell
- if the current value is too small, move down
- if it is too large, move left
- if it matches, return `true`

## Complexity

- Time: `O(m + n)`
- Space: `O(1)`

## Related Pattern

- [staircase_matrix_search.md](staircase_matrix_search.md)
