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
    int capacity = 0;
    Map<Integer, CacheEntry> map = new HashMap<>();
    LinkedList<CacheEntry> list = new LinkedList<>();

    public LRUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (map.containsKey(key)) {
        CacheEntry entry = map.get(key);
        list.remove(entry);
        list.add(entry);
        return entry.value;
      }
      return -1;
    }

    public void put(int key, int value) {
      CacheEntry entry = new CacheEntry(key, value);
      if (map.size() < capacity) {
        list.remove(map.get(key));
      }
      else { //delete least entry
        if (map.containsKey(key)) {
          list.remove(map.get(key));
        }
        else {
          var least = list.removeFirst();
          map.remove(least.key);
        }
      }
      list.add(entry);
      map.put(key, list.getLast());
    }

    class CacheEntry {
      Integer key = null;
      Integer value = null;

      CacheEntry(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
