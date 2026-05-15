# Two Sum

Uses a `HashMap` from value to index so each number can look up its needed complement in constant average time.

## Approach

- scan the array once
- compute `target - nums[i]`
- if that complement is already in the map, return the saved index and `i`
- otherwise store the current value and index

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [../hash_set_and_hash_map.md](../hash_set_and_hash_map.md)
