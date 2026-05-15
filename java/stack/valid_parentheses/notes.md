# Valid Parentheses

Uses a stack to enforce that every closing bracket matches the most recent unmatched opening bracket.

## Approach

- push opening brackets
- when a closing bracket appears, it must match the top of the stack
- at the end, the stack must be empty

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [balanced_delimiter_stack.md](balanced_delimiter_stack.md)
