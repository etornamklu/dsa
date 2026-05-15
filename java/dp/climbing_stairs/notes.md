# Climbing Stairs

This is a Fibonacci-style bottom-up dynamic programming problem.

## Approach

- the number of ways to reach step `i` equals ways to reach `i - 1` plus ways to reach `i - 2`
- keep only the previous two values instead of a full array

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../bottom_up_dynamic_programming.md](../bottom_up_dynamic_programming.md)
