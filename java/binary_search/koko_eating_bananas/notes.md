# Koko Eating Bananas

Binary-searches the minimum eating speed that still finishes all piles within `h` hours.

## Approach

- search the answer range from `1` to `max(piles)`
- for a candidate speed `k`, compute total hours needed
- if the hours fit, try a smaller speed
- otherwise try a larger speed

## Complexity

- Time: `O(n log m)` where `m` is the largest pile
- Space: `O(1)`

## Related Pattern

- [binary_search_on_answer.md](binary_search_on_answer.md)
