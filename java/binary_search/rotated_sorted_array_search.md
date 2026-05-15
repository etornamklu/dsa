# Rotated Sorted Array Search

Rotated sorted array problems still use binary search, but first exploit the structure created by the pivot.

## Core Idea

A rotated sorted array is made of two sorted segments.

You can:

1. find the pivot, which is the smallest element
2. decide which sorted half could contain the target
3. run normal binary search on that half

## When It Appears Here

- `min_in_rotated_sorted_array`
- `search_in_rotated_sorted_array`

## Finding The Pivot

Compare the middle element to the right boundary.

- if `nums[m] < nums[r]`, the minimum is at `m` or to the left
- otherwise, the minimum is to the right of `m`

```java
while (l < r) {
    int m = l + (r - l) / 2;
    if (nums[m] < nums[r]) r = m;
    else l = m + 1;
}
```

At the end, `l` is the pivot.

## Why It Works

The right side tells you which sorted segment `m` belongs to.

That lets you safely eliminate half of the search space even though the full array is not globally sorted.

## Recognition Signals

Use this pattern when:

- the array was originally sorted
- then rotated
- values are unique or duplicates are handled explicitly

## Common Mistakes

- Treating the whole array as normally sorted.
- Using the left boundary comparison when your implementation logic assumes right-boundary comparison.
- Setting `r = pivot` instead of `pivot - 1` in the second search phase when using inclusive ranges.

## Complexity

- Time: `O(log n)`
- Space: `O(1)`
