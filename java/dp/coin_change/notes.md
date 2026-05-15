# Coin Change

Uses bottom-up dynamic programming where each amount builds from smaller reachable amounts.

## Approach

- let `dp[i]` be the minimum coins needed for amount `i`
- initialize unreachable states with a large sentinel
- for each amount, try every coin and relax from `dp[i - coin] + 1`

## Complexity

- Time: `O(amount * number_of_coins)`
- Space: `O(amount)`

## Related Pattern

- [../bottom_up_dynamic_programming.md](../bottom_up_dynamic_programming.md)
