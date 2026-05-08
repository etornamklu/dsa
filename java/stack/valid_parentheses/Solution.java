package stack.valid_parentheses;

import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = Map.of(
            ')','(',
            ']', '[',
            '}', '{'
        );

        for(char c : s.toCharArray()) {
            if(closeToOpen.containsKey(c)) { // check if closing tag
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) { // if closing check if stack is empty if not empty check check if top matches closing
                    stack.pop();
                } else { // if no match immediately terminate
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
