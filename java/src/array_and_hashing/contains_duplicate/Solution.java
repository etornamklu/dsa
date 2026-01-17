package array_and_hashing.contains_duplicate;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    };
}
