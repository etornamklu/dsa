# Classic Binary Search

Classic binary search works on sorted data by discarding half the search space each step.

## Core Idea

- Keep a left boundary `l`.
- Keep a right boundary `r`.
- Check the middle `m`.
- Decide which half can still contain the answer.

## When It Appears Here

- `binary_search`

## Invariant

At every step, if the target exists, it must still lie inside `[l, r]`.

That invariant is what makes the half-discard step safe.

## Typical Shape

```java
int l = 0;
int r = nums.length - 1;

while (l <= r) {
    int m = l + (r - l) / 2;

    if (nums[m] == target) return m;
    if (nums[m] < target) l = m + 1;
    else r = m - 1;
}

return -1;
```

## Why `l + (r - l) / 2`

It avoids integer overflow that can happen with:

```java
(l + r) / 2
```

## Recognition Signals

Use this when:

- the input is sorted
- each comparison tells you which half is impossible
- you need `O(log n)` lookup

## Common Mistakes

- Using the wrong loop condition for the chosen boundary style.
- Forgetting to move past `m`, causing an infinite loop.
- Applying binary search when the data is not monotonic.

## Complexity

- Time: `O(log n)`
- Space: `O(1)`
