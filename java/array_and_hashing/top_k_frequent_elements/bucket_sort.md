# Bucket Sort For Frequency Problems

Bucket sort is useful when the value you sort by has a small bounded range.

## Core Idea

For `top_k_frequent_elements`, the frequency of any number is between `1` and `n`.

That means instead of sorting all entries by frequency, you can place each number into a bucket indexed by its frequency.

## When It Appears Here

- `top_k_frequent_elements`

## Why It Works

If a number appears `f` times, put it in:

```java
bucket.get(f)
```

Then iterate from the highest-frequency bucket down until you collect `k` elements.

This avoids a full `O(m log m)` sort over the distinct values.

## Typical Shape

```java
List<List<Integer>> bucket = new ArrayList<>();
for (int i = 0; i <= nums.length; i++) {
    bucket.add(new ArrayList<>());
}

for (var entry : count.entrySet()) {
    bucket.get(entry.getValue()).add(entry.getKey());
}
```

Then scan backward:

```java
for (int i = bucket.size() - 1; i >= 0 && index < k; i--) {
    for (int num : bucket.get(i)) {
        res[index++] = num;
        if (index == k) break;
    }
}
```

## Recognition Signals

Use this when:

- you need top or bottom frequencies
- the ranking key is an integer in a bounded range
- you want linear-time grouping by score

## Common Mistakes

- Forgetting the bucket array must be size `n + 1`.
- Sorting when the frequency range already gives a direct indexing strategy.
- Confusing array index with original value.

## Complexity

- Time: `O(n)`
- Space: `O(n)`
