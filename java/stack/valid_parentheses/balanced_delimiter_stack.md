# Balanced Delimiter Stack

This pattern validates nested opening and closing symbols with a stack.

## Core Idea

- push opening symbols
- when a closing symbol appears, the top of the stack must be its matching opener

## When It Appears Here

- `valid_parentheses`

## Why A Stack Fits

The most recently opened delimiter must be the first one closed.

That is exactly last-in, first-out behavior.

## Typical Shape

```java
for (char c : s.toCharArray()) {
    if (isClosing(c)) {
        if (stack.isEmpty() || stack.peek() != matchingOpen(c)) {
            return false;
        }
        stack.pop();
    } else {
        stack.push(c);
    }
}

return stack.isEmpty();
```

## Recognition Signals

Use this when:

- symbols must be properly nested
- close order must reverse open order
- you need bracket, tag, or delimiter matching

## Common Mistakes

- Checking counts only. Correct nesting also matters.
- Forgetting the final `stack.isEmpty()` check.
- Popping without checking whether the stack is empty.

## Complexity

- Time: `O(n)`
- Space: `O(n)` in the worst case
