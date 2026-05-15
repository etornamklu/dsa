# Container With Most Water

Uses opposite-direction pointers and moves the shorter side after each area calculation.

## Approach

- start with the widest container
- compute the area from both ends
- move the shorter wall inward because it limits the current height

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../opposite_direction_two_pointers.md](../opposite_direction_two_pointers.md)
