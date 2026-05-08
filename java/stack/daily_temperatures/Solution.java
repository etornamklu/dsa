package stack.daily_temperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int t = temperatures[i];

            // Pop all the temperatures that are less than the current temperature and update the output for those indices
            // The stack will store pairs of [temperature, index]
            // For each temperature, we check if it is greater than the temperature at the top of the stack.
            // If it is, we pop from the stack and calculate the number of days until a warmer(higher) temperature for that index.
            // We continue this process until we find a temperature that is not less than the current temperature or the stack is empty.
            // After processing the stack, we push the current temperature and its index onto the stack for future comparisons.
            // This way, we ensure that we are always comparing the current temperature with the temperatures that came before it 
            // and we can efficiently calculate the number of days until a warmer temperature for each day.
            while(!stack.isEmpty() && t > stack.peek()[0]){
                int[] pair = stack.pop();
                output[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});

        }
        return output;
    }
    
}
