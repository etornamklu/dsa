package two_pointers.container_w_most_water;

class Solution {
    public static int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length - 1;
        int result = 0;

        while (l < r){
            int area = Math.min(heights[l],heights[r]) * (r - l);
            if (area > result) result = area;

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return result;
        
    }

    public static void main(String[] args){
        System.out.println(Solution.maxArea(new int[]{2,2,2}));
    }
}
