package com.lilhui.leecode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/01 15:43
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRU(int initialCapacity, float loadFactor, int maxSize) {
        super(initialCapacity, loadFactor, true);
        MAX_CACHE_SIZE = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

}
