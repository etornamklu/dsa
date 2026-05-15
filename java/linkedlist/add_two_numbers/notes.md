# Add Two Numbers

This solution simulates grade-school addition digit by digit while walking both linked lists in parallel.

## Approach

- keep a `carry` value
- read the current digit from `l1` and `l2`, using `0` if one list is shorter
- compute `sum = v1 + v2 + carry`
- create a new node with `sum % 10`
- update `carry = sum / 10`
- continue until both lists are exhausted and `carry` is `0`

## Why It Works

The lists store digits in reverse order, so the head contains the ones place.

That means we can add from left to right in the linked list and naturally propagate carry forward, just like normal column addition.

## Complexity

- Time: `O(max(n, m))`
- Space: `O(max(n, m))` for the output list

## Related Pattern

- [../dummy_node_technique.md](../dummy_node_technique.md)

## Special Algorithm?

Not really. This is mostly:

- linked-list traversal
- carry propagation
- result construction with a dummy node

It is better viewed as a simulation problem than a special standalone algorithm pattern.
