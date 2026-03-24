package stack.car_fleet;

import java.util.Arrays;
import java.util.Stack;


// The car fleet problem is a problem where we have a target distance and a list of cars with their positions and speeds.
// The goal is to determine how many car fleets will arrive at the target. A car fleet is a group of cars that travel together at the same speed and arrive at the target together.
// To solve this problem, we can use a stack to keep track of the time it takes for each car to reach the target. We can sort the cars by their starting position in descending order
// and then iterate through the sorted list of cars. For each car, we calculate the time it takes to reach the target and compare it with the time of the car at the top of the stack.
// If the time of the current car is greater than the time of the car at the top of the stack, it means that the current car will not catch up to the car at the top
// and will form a new fleet. In this case, we push the time of the current car onto the stack. If the time of the current car is less than or equal to the time of the car at the top of the stack,
// it means that the current car will catch up to the car at the top and they will form a fleet together. In this case, we do not push the time of the current car onto the stack, as it will be part of the same fleet as the car at the top. 
// After iterating through all the cars, the number of fleets will be equal to the size of the stack, as each time we push a time onto the stack, it represents a new fleet.

// This isn't necessarily the most efficient solution, but it is a straightforward way to solve the problem using a stack. The time complexity of this solution is O(n log n) due to the sorting step, and the space complexity is O(n) in the worst case if all cars form separate fleets.
// You can optimize the space complexity to O(1) by using a variable to keep track of the last time instead of using a stack, but the overall approach remains the same.

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(int[] p: pair){
            Double time = (double) (target - p[0]) / p[1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
