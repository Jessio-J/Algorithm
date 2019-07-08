package P101TO150.P146;

import java.util.LinkedHashMap;

public class P146 {
    static class LRUCache {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                int value = hashMap.get(key);
                hashMap.remove(key);
                hashMap.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (!hashMap.containsKey(key)&&hashMap.size() >= capacity) {
                hashMap.remove(hashMap.entrySet().iterator().next().getKey());
            }
            if(hashMap.containsKey(key)){
                hashMap.remove(key);
            }
            hashMap.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4
    }
}
