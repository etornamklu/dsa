# Monotonic Stack

A monotonic stack keeps elements in sorted order inside the stack so each new element can resolve pending questions efficiently.

## Core Idea

While processing values from left to right:

- pop stack elements that are no longer useful
- use the current value to answer the popped elements
- push the current value for future comparisons

## When It Appears Here

- `daily_temperatures`
- `car_fleet` uses a closely related monotonic-time idea after sorting by position

## Daily Temperatures

The stack stores unresolved days.

Each entry needs:

- the temperature
- the index

When a warmer day arrives, pop colder entries and fill their answer.

## Why It Works

Each index is pushed once and popped once, so the total work stays linear.

Without the monotonic stack, a naive approach would keep scanning forward for each day.

## Typical Shape

```java
while (!stack.isEmpty() && current > stack.peek()[0]) {
    int[] pair = stack.pop();
    answer[pair[1]] = i - pair[1];
}
stack.push(new int[]{current, i});
```

## Recognition Signals

Use this when the problem asks for:

- next greater element
- next smaller element
- previous greater or smaller element
- how far until a future condition becomes true

## Common Mistakes

- Storing only values when indices are needed for the answer.
- Picking the wrong monotonic direction.
- Forgetting that the stack usually stores unresolved candidates, not final answers.

## Complexity

- Time: `O(n)`
- Space: `O(n)`
