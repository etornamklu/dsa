# Node Mapping Clone

This pattern clones a linked structure by mapping every original node to its copied node.

## Core Idea

When nodes contain extra pointers such as `random`, copying values alone is not enough.

You first create all copied nodes, then reconnect their relationships using a map:

```java
Map<OldNode, NewNode> oldToCopy
```

## When It Appears Here

- `copy_linked_list_with_random_pointer`

## Two-Pass Strategy

### Pass 1

Create a copy node for every original node and store the mapping.

### Pass 2

Use the mapping to assign:

- `copy.next`
- `copy.random`

## Why It Works

During the first pass, the target copy nodes may not all exist yet.

The map separates node creation from pointer linking, so every relationship can be reconstructed safely afterward.

## Typical Shape

```java
Map<Node, Node> oldToCopy = new HashMap<>();
oldToCopy.put(null, null);
```

The `null -> null` mapping is a nice trick that removes extra null checks for `next` and `random`.

## Recognition Signals

Use this when:

- a graph or linked structure has cross-links
- copied nodes must preserve identity relationships
- rebuilding pointers directly in one pass would be awkward

## Common Mistakes

- Copying values but not pointer relationships.
- Forgetting that two original pointers to the same node must point to the same copied node.
- Recreating copies multiple times instead of reusing the map.

## Complexity

- Time: `O(n)`
- Space: `O(n)`
