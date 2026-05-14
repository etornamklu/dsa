package linkedlist.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;

    // left = LRU, right = most recently used
    // dummy nodes to avoid null checks
    private Node left;
    private Node right;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        // connect the dummy nodes
        this.left.next = this.right; // connect the left dummy node to the right dummy node ( left dummy -> right dummy )
        this.right.prev = this.left; // connect the right dummy node to the left dummy node ( left dummy <- right dummy )
    }

    private void remove(Node node){
        Node leftNode = node.prev; // get the left node of the node to be removed
        Node rightNode = node.next; // get the right node of the node to be removed
        leftNode.next = rightNode; // connect the left node to the right node ( left node -> right node )
        rightNode.prev = leftNode; // connect the right node to the left node ( left node <- right node )
    }
    
    private void insert(Node node){

        Node mostRecentUsedNode = this.right.prev; // get the current most recently used node
        mostRecentUsedNode.next = node; // connect the current most recently used node to the new node ( current most recent -> new node )
        node.prev = mostRecentUsedNode; // connect the new node to the current most recently used node ( current most recent <- new node )
        node.next = this.right; // connect the new node to the right dummy node ( new node -> right dummy )
        this.right.prev = node; // connect the right dummy node to the new node ( new node <- right dummy )
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        } // if the key is found in the cache, move the corresponding node to the most recently used position and return its value

        return -1; // return -1 if the key is not found in the cache
    }

    public void put(int key, int value){
        if (cache.containsKey(key)) remove(cache.get(key)); 
        // if the key is already in the cache, remove the corresponding node from the linked list 

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        // insert the new node into the linked list and add it to the cache


        if (cache.size() > capacity){
            Node lru = this.left.next; // get the least recently used node ( the node right after the left dummy node )
            remove(lru); // remove the least recently used node from the linked list
            cache.remove(lru.key); // remove the least recently used node from the cache using its key
        }
        // if the cache exceeds its capacity, remove the least recently used node from the linked list and delete it from the cache
    }


}