# Contains Duplicate

Uses a `HashSet` to track values already seen while scanning the array once.

## Approach

- iterate through `nums`
- if a value is already in the set, return `true`
- otherwise add it and continue

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [hash_set_and_hash_map.md](../hash_set_and_hash_map.md)
