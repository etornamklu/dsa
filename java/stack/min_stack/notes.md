# Min Stack

Uses an auxiliary stack to keep track of the current minimum in constant time.

## Approach

- push every value to the main stack
- also push to the min stack whenever the new value is less than or equal to the current minimum
- when popping, remove from the min stack too if the popped value equals the current minimum

## Complexity

- `push`: `O(1)`
- `pop`: `O(1)`
- `top`: `O(1)`
- `getMin`: `O(1)`

## Related Pattern

- [auxiliary_min_stack.md](auxiliary_min_stack.md)
