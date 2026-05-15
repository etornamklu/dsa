# Hash Map Plus Doubly Linked List

This is the standard `O(1)` design for an LRU cache.

## Core Idea

Combine:

- a `HashMap` for direct key lookup
- a doubly linked list for recency order

## When It Appears Here

- `lru_cache`

## Why Both Structures Are Needed

### HashMap

Gives `O(1)` access from key to node.

### Doubly linked list

Lets you remove and reinsert a node in `O(1)` when it becomes recently used.

A singly linked list would not support arbitrary removal in constant time because you would not have the previous node.

## Standard Layout

- left side = least recently used
- right side = most recently used
- dummy boundary nodes simplify insert and remove

## Operations

### `get(key)`

- if key not found, return `-1`
- otherwise remove the node from its current position
- move it to the most-recent side

### `put(key, value)`

- if key already exists, remove the old node
- insert the new or updated node as most recent
- if over capacity, evict the least recently used node

## Why It Works

The map answers "where is this key?"

The linked list answers "which key is oldest or newest?"

Together they satisfy both requirements in constant time.

## Recognition Signals

Use this design when:

- you need eviction by recency
- both lookup and update must be `O(1)`
- you need stable ordering under frequent access

## Common Mistakes

- Using a singly linked list and losing `O(1)` removal.
- Forgetting to update both the map and the list on eviction.
- Not using dummy nodes and ending up with fragile null-check logic.

## Complexity

- `get`: `O(1)`
- `put`: `O(1)`
- Space: `O(capacity)`
