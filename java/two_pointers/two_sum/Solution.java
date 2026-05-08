package two_pointers.two_sum;

public class Solution {

    public int[] twoSum(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            int add = nums[l] + nums[r];
            if(add > target){
                r--;
            } else if(add < target) {
                l++;
            } else {
                return new int[]{l,r};
            }
        }
        return new int[]{-1,1};
    }
    
}
