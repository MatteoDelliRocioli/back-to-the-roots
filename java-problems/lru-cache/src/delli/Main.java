package delli;

import java.util.*;

public class Main {

  /**
   * https://leetcode.com/problems/lru-cache/
   *
   * queue-like data structure -> keep track of least recently used element (first element inserted)
   * hashtable (HashMap) -> to host the elements for O(1) get and insert
   * */
  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
  }

  class LRUCache {

//    Queue<Integer> accessedKeys = new LinkedList<>(); // FIFO data structure
    List<Integer> accessedKeys = new ArrayList<>(); // use it like a FIFO data structure
    HashMap<Integer, Integer> map = null;
    int capacity = 0;

    public LRUCache(int capacity) {
      map = new HashMap<>(capacity);
      this.capacity = capacity;
    }

    public int get(int key) {
      if (map.containsKey(key)) {
        updateAccessedKeys(key);
        return map.get(key);
      }
      return -1;
    }

    public void put(int key, int value) {
      //if exists
      if (map.containsKey(key)) {
        updateAccessedKeys(key);
        map.put(key, value);
      }
      //does not exist
      else {
        //if empty places available
        if (capacity > accessedKeys.size()) {
          accessedKeys.add(key);
          map.put(key, value);
        }
        //else the capacity is reached
        else {
          //remove least accessed key from map and update accessed list
          int leastKey = accessedKeys.get(0);
          map.remove(leastKey);
          map.put(key, value);
          upsertAccessedKeys(leastKey, key);
          //updateAccessedKeys(key);
        }
      }
    }

    private void updateAccessedKeys(int key){
      if (accessedKeys.contains(key)) {
        var temp = accessedKeys.remove(accessedKeys.indexOf(key));
        accessedKeys.add(temp);
      }
      else {
        accessedKeys.add(key);
      }
    }

    private void upsertAccessedKeys(int leastKey, int newKey) {
      accessedKeys.remove(accessedKeys.indexOf(leastKey));
      accessedKeys.add(newKey);
    }
  }
  /**
   * Your LRUCache object will be instantiated and called as such:
   * LRUCache obj = new LRUCache(capacity);
   * int param_1 = obj.get(key);
   * obj.put(key,value);
   */
}
