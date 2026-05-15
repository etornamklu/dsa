# Copy Linked List With Random Pointer

Copies each original node once, stores the old-to-new mapping, then reconnects `next` and `random` pointers in a second pass.

## Approach

- create a copy node for every original node
- store `oldNode -> copiedNode` in a map
- walk the list again and wire `next` and `random` using the map

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [node_mapping_clone.md](node_mapping_clone.md)
