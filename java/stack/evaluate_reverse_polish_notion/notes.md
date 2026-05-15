# Evaluate Reverse Polish Notation

Evaluates the postfix expression with a stack of operands and intermediate results.

## Approach

- push numbers onto the stack
- when an operator appears, pop the required operands
- apply the operator
- push the result back

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Related Pattern

- [expression_evaluation_stack.md](expression_evaluation_stack.md)
