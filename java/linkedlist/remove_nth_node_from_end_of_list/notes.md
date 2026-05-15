# Remove Nth Node From End Of List

Uses a fixed gap between two pointers so that when the fast pointer reaches the end, the slow pointer is right before the node to remove.

## Approach

- create a dummy node before the head
- move `fast` ahead by `n` nodes
- move `slow` and `fast` together until `fast` reaches the end
- delete `slow.next`

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Related Pattern

- [../slow_and_fast_pointers.md](../slow_and_fast_pointers.md)
- [../dummy_node_technique.md](../dummy_node_technique.md)
