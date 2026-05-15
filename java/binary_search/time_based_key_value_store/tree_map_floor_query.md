# TreeMap Floor Query

This pattern stores values in sorted key order and answers nearest-previous queries efficiently.

## Core Idea

Use:

- a `HashMap` for the outer key
- a `TreeMap` for ordered timestamps inside each key

Then query:

```java
floorEntry(timestamp)
```

to get the value at the greatest time less than or equal to the target.

## When It Appears Here

- `time_based_key_value_store`

## Why It Works

For each logical key, timestamps are an ordered search space.

A `TreeMap` keeps them sorted and supports logarithmic predecessor lookup.

## Typical Shape

```java
Map<String, TreeMap<Integer, String>> map = new HashMap<>();
map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
```

Then:

```java
Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
```

## Recognition Signals

Use this when:

- values are versioned by time or sequence number
- you need the latest value not after a query point
- each key has many ordered updates

## Common Mistakes

- Using a plain `HashMap` when order matters.
- Re-scanning all timestamps instead of using ordered-map operations.
- Forgetting that `floorEntry` can return `null`.

## Complexity

- `set`: `O(log n)` for a given key
- `get`: `O(log n)` for a given key
- Space: `O(total updates)`
