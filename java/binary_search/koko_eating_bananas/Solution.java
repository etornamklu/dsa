package binary_search.koko_eating_bananas;

// The idea is to use binary search to find the minimum eating speed that allows Koko to eat all the bananas within h hours.
// We can define the search space for the eating speed as [1, max(piles)], where max(piles) is the maximum number of bananas in any pile. 
// We then calculate the total time needed to eat all the bananas at a given eating speed k, and adjust our search space accordingly until we find the minimum valid eating speed.
// The time complexity of this solution is O(n log m), where n is the number of piles and m is the maximum number of bananas in any pile.
// We can also use long to avoid integer overflow when calculating total time, since the total time can be very large when the number of bananas is large and the eating speed is small.

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;

        // find the max pile
        for (int pile : piles) {
            if (pile > r) {
                r = pile;
            }
        }


        while(l <= r){
             int k = l + (r - l) / 2; // eating speed 

            // calculate the total time needed to eat all the bananas at speed k
            // we can use (pile + k - 1) / k to calculate the time needed to eat a pile of bananas at speed k
            // this is because if pile is not divisible by k, we need to eat one more time to finish the remaining bananas
            long totalTime = 0;
            for(int pile : piles) {
                totalTime += (pile + k - 1)/ k ;

            }

            // if the total time needed is less than or equal to h, we can try to eat slower
            // if the total time needed is greater than h, we need to eat faster
            // we also need to update the result when we find a valid eating speed
            if (totalTime <= h) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return l;
        
    }
}
