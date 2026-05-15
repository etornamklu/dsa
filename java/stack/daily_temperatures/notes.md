# Daily Temperatures

Uses a monotonic stack of unresolved days to find the next warmer temperature for each index.

## Approach

- store `[temperature, index]` pairs on the stack
- when a warmer temperature arrives, pop colder days
- fill each popped day with the index difference

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [../monotonic_stack.md](../monotonic_stack.md)
