# Opposite-Direction Two Pointers

This pattern places one pointer at the left end and one at the right end, then moves them inward based on what the current comparison tells you.

## Core Idea

- `l` starts at the beginning
- `r` starts at the end
- each step removes one impossible side

## When It Appears Here

- `two_sum`
- `is_palindrone`
- `container_w_most_water`

## 1. Sorted Two Sum

Because the array is sorted:

- if `nums[l] + nums[r]` is too small, increase `l`
- if it is too large, decrease `r`

This works because moving the correct side is the only way to improve the sum.

## 2. Valid Palindrome

Compare characters from both ends while skipping non-alphanumeric characters.

This avoids building a cleaned string first.

## 3. Container With Most Water

Compute the area formed by both ends:

```text
min(height[l], height[r]) * (r - l)
```

Then move the shorter side, because the shorter line is the limiting height.

Moving the taller side cannot increase the area while width shrinks and the limiting height stays unchanged.

## Recognition Signals

Use this when:

- the input is sorted or symmetric
- the answer depends on pairs from both ends
- each comparison eliminates one boundary safely

## Common Mistakes

- Applying it to an unsorted sum problem that actually needs hashing.
- Moving both pointers at once and skipping candidates.
- Moving the wrong side in container problems.

## Complexity

- Time: usually `O(n)`
- Space: `O(1)`
