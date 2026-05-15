# Auxiliary Min Stack

This pattern augments a normal stack with a second stack that tracks the current minimum.

## Core Idea

Keep:

- the main stack for values
- a min stack for the minimum values seen so far

## When It Appears Here

- `min_stack`

## Why It Works

When a new value is pushed:

- if it is smaller than or equal to the current minimum, push it onto the min stack too

When a value is popped:

- if it equals the current minimum, pop from the min stack as well

That preserves the minimum for the remaining prefix of the stack.

## Typical Shape

```java
if (minStack.isEmpty() || val <= getMin()) {
    minStack.push(val);
}
```

and on pop:

```java
int top = stack.pop();
if (top == getMin()) {
    minStack.pop();
}
```

## Recognition Signals

Use this when:

- you need normal stack behavior
- plus an aggregate query like minimum in `O(1)`

## Common Mistakes

- Tracking only strictly smaller values and breaking duplicate minimum handling.
- Forgetting to synchronize the two stacks on pop.
- Returning from an empty stack without a clear contract.

## Complexity

- `push`: `O(1)`
- `pop`: `O(1)`
- `top`: `O(1)`
- `getMin`: `O(1)`
