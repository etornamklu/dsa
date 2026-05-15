# Top K Frequent Elements

Counts frequencies first, then uses buckets indexed by frequency to collect the top `k` values without sorting all distinct entries.

## Approach

- count occurrences with a map
- place each number into `bucket[freq]`
- walk buckets from high frequency to low frequency until `k` elements are collected

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [../frequency_counting.md](../frequency_counting.md)
- [bucket_sort.md](bucket_sort.md)
