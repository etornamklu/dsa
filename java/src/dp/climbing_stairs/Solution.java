package dp.climbing_stairs;

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// The bottom up solution is similar to the fibonacci sequence, 
// where the number of ways to reach the top is the sum of the ways to reach the last step and the step before that.
// We can use two variables to keep track of these values and iteratively calculate the number of ways to climb to the top.

class Solution {
    public int climbStairs(int n) {
    int top = 1;
    int bottom = 1;

    for (int i = 0; i < n - 1; i++) {
        int temp = bottom;
        bottom = top + bottom;
        top = temp;
    }
      return bottom;  
    }
}