# Bottom-Up Dynamic Programming

Bottom-up dynamic programming builds answers for small subproblems first, then reuses them to solve larger ones.

## Core Idea

- Define a state.
- Define a recurrence.
- Fill the answers from the base case upward.

## When It Appears Here

- `climbing_stairs`
- `coin_change`

## 1. Climbing Stairs

State:

- `dp[i]` = number of ways to reach step `i`

Recurrence:

```text
dp[i] = dp[i - 1] + dp[i - 2]
```

This is Fibonacci-style DP.

Because each state only needs the previous two states, space can be compressed to two variables.

## 2. Coin Change

State:

- `dp[i]` = minimum number of coins needed to make amount `i`

Recurrence:

```text
dp[i] = min(dp[i], dp[i - coin] + 1)
```

for every usable coin.

## Why Bottom-Up Works

Each larger state depends only on smaller states that have already been computed.

That removes repeated work found in naive recursion.

## Recognition Signals

Use bottom-up DP when:

- the problem has overlapping subproblems
- the answer can be built from smaller answers
- brute force would repeat the same states many times

## Common Mistakes

- Defining the state too vaguely.
- Missing the correct base case.
- Using an impossible sentinel value incorrectly.
- Forgetting that some DP problems allow space compression.

## Complexity

Depends on the state space, but typically:

- Time: number of states times transitions per state
- Space: number of stored states
