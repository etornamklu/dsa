# Valid Anagram

Uses fixed-size frequency counting because the input is lowercase English letters.

## Approach

- return early if lengths differ
- increment counts for characters in `s`
- decrement counts for characters in `t`
- if every count returns to zero, the strings are anagrams

## Complexity

- Time: `O(n)`
- Space: `O(1)` because the alphabet size is fixed

## Related Pattern

- [../frequency_counting.md](../frequency_counting.md)
