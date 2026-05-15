# Frequency Counting

Frequency counting turns elements into counts, then uses those counts to compare, group, or rank data.

## Core Idea

- Count how many times each value appears.
- Use the count structure as a signature or as input to another algorithm.

## When It Appears Here

- `valid_anagram` uses a fixed-size count array.
- `group_anagram` builds a frequency signature for each word.
- `top_k_frequent_elements` starts by building a frequency map.

## Two Main Variants

### 1. Fixed alphabet counting

Use an array when the possible values are small and known ahead of time, like lowercase English letters.

```java
int[] count = new int[26];
```

This is faster and simpler than a map.

### 2. General value counting

Use a `HashMap` when values are arbitrary.

```java
Map<Integer, Integer> count = new HashMap<>();
count.merge(num, 1, Integer::sum);
```

## Why It Works For Anagrams

Two strings are anagrams if they contain exactly the same characters with exactly the same counts.

That means the count vector is a reliable signature:

```java
[1,0,0,2,...]
```

If two strings have the same signature, they belong in the same group.

## Recognition Signals

Use this pattern when the problem asks for:

- whether two collections have the same composition
- grouping equivalent strings
- top frequent elements
- histogram-style summaries

## Common Mistakes

- Using sorting for anagrams when fixed-size counting is cheaper.
- Forgetting to compare lengths first in anagram problems.
- Building an unstable key for grouped counts.

## Complexity

- Time: usually `O(n)` over the input size
- Space: `O(k)` where `k` is the number of distinct values or the alphabet size
