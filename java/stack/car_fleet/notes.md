# Car Fleet

Sorts cars by starting position from nearest to farthest from the target, then tracks fleet arrival times monotonically.

## Approach

- pair each car’s position with its speed
- sort by position descending
- compute each car’s time to reach the target
- a new fleet forms only when the current time is greater than the latest fleet time

## Complexity

- Time: `O(n log n)` because of sorting
- Space: `O(n)` with the current stack implementation

## Related Pattern

- [../monotonic_stack.md](../monotonic_stack.md)
