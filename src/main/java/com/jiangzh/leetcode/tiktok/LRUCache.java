package com.jiangzh.leetcode.tiktok;

import java.util.LinkedHashMap;

/**
 * @author jiangzheng
 * @version 1.0
 * @description: 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 */
public class LRUCache {

    int capacity = 0;
    LinkedHashMap<Integer,Integer> cache = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size() < capacity){
            cache.put(key,value);
        }else{
            int delKey = cache.keySet().iterator().next();
            cache.remove(delKey);
            cache.put(key,value);
        }
    }

    private void makeRecently(int key){
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }

}
