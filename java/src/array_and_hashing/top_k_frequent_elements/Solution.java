package array_and_hashing.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int num : nums){
            count.merge(num, 1, Integer::sum);
        }

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(var entry: count.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            for (int n: bucket[i]) {
                res[index++] = n;
                if (index == k) break;
            }
        }

        return res;
    }
}
