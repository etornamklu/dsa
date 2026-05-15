# Staircase Matrix Search

This pattern searches a row- and column-sorted matrix without flattening it.

## Core Idea

Start from the top-right corner.

At each step:

- if the current value is too small, move down
- if the current value is too large, move left
- if it matches, return `true`

## When It Appears Here

- `search_2d_matrix`

## Why The Top-Right Corner

From the top-right cell:

- everything below is larger
- everything to the left is smaller

That means one comparison always removes either a full row or a full column.

## Typical Shape

```java
int r = 0;
int c = cols - 1;

while (r < rows && c >= 0) {
    if (matrix[r][c] < target) r++;
    else if (matrix[r][c] > target) c--;
    else return true;
}

return false;
```

## Recognition Signals

Use this when:

- rows are sorted left to right
- columns are sorted top to bottom
- you want simpler logic than flattening to one index space

## Common Mistakes

- Assuming this works on an arbitrary 2D matrix.
- Starting from a corner that does not give a clean eliminate-one-dimension rule.
- Confusing this with the other matrix problem where the whole matrix can be treated as one sorted array.

## Complexity

- Time: `O(m + n)`
- Space: `O(1)`
