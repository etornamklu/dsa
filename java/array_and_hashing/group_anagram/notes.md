# Group Anagram

Builds a frequency signature for each string and uses that signature as the grouping key in a map.

## Approach

- count the letters in each word with a `26`-slot array
- convert the count array into a stable key
- append the word into the map bucket for that key

## Complexity

- Time: `O(n * k)` where `k` is average word length
- Space: `O(n * k)`

## Related Pattern

- [../frequency_counting.md](../frequency_counting.md)
