package binary_search.time_based_key_value_store;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

// 981. Time Based Key-Value Store
// Design a time-based key-value data structure that can store multiple values for the same key at
// different time stamps and retrieve the key's value at a certain timestamp.
// Implement the TimeMap class:
// - TimeMap() Initializes the object of the data structure.
// - void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
// - String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values,

class TimeMap {
    // we can use a hash map to store the key and a tree map to store the timestamp and value pairs for each key
    // the tree map allows us to efficiently find the value for a given timestamp using the floorEntry method, 
    // which returns the greatest key less than or equal to the given key (timestamp in this case)

    // the time complexity of the set method is O(log n) due to the insertion into the tree map, where n is the number of timestamps for that key
    // the time complexity of the get method is O(log n) due to the floorEntry method, where n is the number of timestamps for that key
    // the space complexity is O(m) where m is the total number of set operations, as we are storing all the key-value pairs in the hash map and tree maps
    private Map<String, TreeMap<Integer, String>> m;

    public TimeMap() {
        m = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        // we can use computeIfAbsent to initialize the tree map for the key if it does not exist, and then put the timestamp and value in the tree map
        // this is a more concise way to write the code compared to checking if the key exists and then initializing the tree map if it does not exist
        m.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) return "";

        // we can use the floorEntry method of the tree map to find the greatest key less than or equal to the given timestamp, which will give us the value for that timestamp
        // if there is no such key (timestamp) in the tree map, it means that there was no set operation for that key at or before the given timestamp, so we return an empty string
        TreeMap<Integer, String> timestamps = m.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
        
    }
}

