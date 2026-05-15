# Valid Palindrome

Uses two pointers from both ends while skipping non-alphanumeric characters.

## Approach

- lowercase the string
- move `l` right until it points at a letter or digit
- move `r` left until it points at a letter or digit
- compare both characters and continue inward

## Complexity

- Time: `O(n)`
- Space: `O(n)` in this implementation because it converts to a char array

## Related Pattern

- [../opposite_direction_two_pointers.md](../opposite_direction_two_pointers.md)
