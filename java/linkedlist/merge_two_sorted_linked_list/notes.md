# Merge Two Sorted Linked List

Builds the merged list incrementally with a dummy head and a moving tail pointer.

## Approach

- compare the current nodes of both lists
- attach the smaller node to the result tail
- advance that list and the tail
- append the remaining list once one side is exhausted

## Complexity

- Time: `O(n + m)`
- Space: `O(1)` excluding the output links reused from the inputs

## Related Pattern

- [../dummy_node_technique.md](../dummy_node_technique.md)
