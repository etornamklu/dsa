# Hash Set And Hash Map

This pattern trades extra memory for fast lookup.

## Core Idea

- Use a `HashSet` when you only need existence checks.
- Use a `HashMap` when you need to store extra information for each key.
- Average-case lookup, insert, and delete are `O(1)`.

## When It Appears Here

- `contains_duplicate` uses a `HashSet` to detect repeats.
- `two_sum` uses a `HashMap` to remember values already seen.

## Why It Works

Instead of scanning the array again to answer "have I seen this before?", the hash structure answers that immediately.

That turns many brute-force `O(n^2)` solutions into `O(n)`.

## Typical Shapes

### Existence check

```java
Set<Integer> seen = new HashSet<>();

for (int num : nums) {
    if (seen.contains(num)) return true;
    seen.add(num);
}
```

### Value to index mapping

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    int need = target - nums[i];
    if (map.containsKey(need)) {
        return new int[]{map.get(need), i};
    }
    map.put(nums[i], i);
}
```

## Recognition Signals

Use this pattern when the problem asks for:

- duplicate detection
- complement lookup
- matching pairs
- fast membership testing
- counting or grouping by key

## Common Mistakes

- Forgetting that duplicate keys overwrite earlier values in a `HashMap`.
- Using a map when a set is enough.
- Missing edge cases around `null` or empty inputs.
- Assuming hash structures preserve insertion order. `HashMap` and `HashSet` do not.

## Complexity

- Time: usually `O(n)` average case
- Space: usually `O(n)`
