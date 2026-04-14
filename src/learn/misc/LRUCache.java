package learn.misc;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true -> Access order.
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> e) {
        return this.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(5);

        cache.put("Malli", "Malli Karjuna");
        cache.put("yathi", "Malli Karjuna");
        cache.put("hayathi", "Malli Karjuna");
        cache.get("Malli");
        cache.put("Arjun", "Malli Karjuna");
        cache.put("Atal", "Malli Karjuna");
        cache.put("kathik", "Malli Karjuna");
        cache.put("preethi", "Malli Karjuna");
        System.out.println(cache.size());
        System.err.println(cache);
    }
}
