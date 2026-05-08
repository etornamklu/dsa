package array_and_hashing.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for(int num : nums){
            count.merge(num, 1, Integer::sum);
        }

        for (int i = 0; i < bucket.size(); i++) {
            bucket.set(i, new ArrayList<>());
        }

        for(var entry: count.entrySet()){
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.size() - 1; i >= 0 && index < k; i--) {
            for (int n: bucket.get(i)) {
                res[index++] = n;
                if (index == k) break;
            }
        }

        return res;
    }
}
