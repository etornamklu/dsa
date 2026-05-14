package binary_search.search_in_rotated_sorted_array;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;

        // find pivot ( the smallest element in the array)

        while ( l < r) {
            int m = l + ( r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;
        l = 0;
        r = nums.length - 1;

        // determine which side to search
        // if the target is greater than or equal to the pivot and less than or equal to the rightmost element,
        //  search in the right half else search in the left half

        if ( target >= nums[pivot] && target <= nums[r]) {
            l = pivot;
        } else {
            r = pivot;
        }

        // perform binary search on the determined half

        while ( l <= r) {
            int m = l + ( r - l) /2;
            if  ( nums[m] == target) {
                return m;
            } else if ( nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            
        }

        return -1;
        
    }
}
