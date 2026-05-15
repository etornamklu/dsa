# LRU Cache

Combines a hash map with a doubly linked list to support `O(1)` lookup, update, and least-recently-used eviction.

## Approach

- map each key to its node
- keep nodes ordered by recency in a doubly linked list
- move accessed nodes to the most-recent side
- evict from the least-recent side when over capacity

## Complexity

- `get`: `O(1)`
- `put`: `O(1)`
- Space: `O(capacity)`

## Related Pattern

- [hash_map_plus_doubly_linked_list.md](hash_map_plus_doubly_linked_list.md)
