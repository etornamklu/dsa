# Time Based Key-Value Store

Stores each key’s updates in a `TreeMap` so queries can find the latest timestamp not after the requested one.

## Approach

- map each string key to a `TreeMap<Integer, String>`
- on `set`, insert the timestamp and value
- on `get`, use `floorEntry(timestamp)` to retrieve the closest earlier update

## Complexity

- `set`: `O(log n)` per key
- `get`: `O(log n)` per key
- Space: `O(total updates)`

## Related Pattern

- [tree_map_floor_query.md](tree_map_floor_query.md)
