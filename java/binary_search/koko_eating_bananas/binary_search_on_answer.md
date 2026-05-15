# Binary Search On Answer

This pattern binary-searches a feasible answer value instead of an array index.

## Core Idea

- Define a search range of possible answers.
- Write a check that says whether a candidate answer is valid.
- Use binary search to find the smallest or largest valid answer.

## When It Appears Here

- `koko_eating_bananas`

## Why It Works

The candidate answer space is monotonic.

For Koko:

- if eating speed `k` is fast enough, any larger speed is also fast enough
- if eating speed `k` is too slow, any smaller speed is also too slow

That true/false boundary is exactly what binary search needs.

## Typical Shape

```java
int l = 1;
int r = maxPile;

while (l <= r) {
    int m = l + (r - l) / 2;

    if (canFinish(m)) {
        r = m - 1;
    } else {
        l = m + 1;
    }
}

return l;
```

## Recognition Signals

Use this pattern when:

- the question asks for a minimum valid value or maximum valid value
- you can test a candidate answer efficiently
- validity changes only once across the answer space

## Common Mistakes

- Binary-searching the input array when the real search space is answer values.
- Missing the monotonicity requirement.
- Returning `m` instead of the final boundary.
- Overflow in feasibility calculations.

## Complexity

Usually:

- Time: `O(log R * checkCost)` where `R` is the answer range
- Space: `O(1)`
