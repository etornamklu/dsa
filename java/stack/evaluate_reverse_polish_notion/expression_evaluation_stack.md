# Expression Evaluation Stack

Stack-based evaluation is a clean fit for postfix expressions because operators act on the most recent operands.

## Core Idea

- push numbers
- when an operator appears, pop the required operands
- compute the result
- push the result back

## When It Appears Here

- `evaluate_reverse_polish_notion`

## Why It Works For Reverse Polish Notation

In postfix notation, each operator appears after its operands.

That means the top of the stack always contains the next values to use.

## Typical Shape

```java
switch (token) {
    case "+" -> stack.push(stack.pop() + stack.pop());
    case "*" -> stack.push(stack.pop() * stack.pop());
    case "/" -> {
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a / b);
    }
    default -> stack.push(Integer.parseInt(token));
}
```

## Important Detail

Operand order matters for non-commutative operators:

- subtraction
- division

So you must usually pop:

1. right operand
2. left operand

then compute `left op right`.

## Recognition Signals

Use this when:

- the expression is postfix
- operators combine the most recent intermediate results
- recursion or explicit parsing would be overkill

## Common Mistakes

- Reversing operand order for `-` or `/`.
- Treating every token as a number.
- Forgetting integer division behavior in Java.

## Complexity

- Time: `O(n)`
- Space: `O(n)`
