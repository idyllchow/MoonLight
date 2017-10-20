package com.zhoushibo.moonlight.util;

import java.util.List;

/**
 * @author shibo
 * @description
 * @date 2017/10/20
 */
public class LruCacheDownloader {

    private static final String TAG = "TextDownload";
    private android.util.LruCache<String, List<?>> lruCache;

    public LruCacheDownloader() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        int cacheSize = (int) (maxMemory / 8);
        lruCache = new android.util.LruCache<String, List<?>>(cacheSize) {
            @Override
            protected int sizeOf(String key, List<?> value) {
                return 1024;
            }
        };
    }

    // 把String对象加入到缓存中
    public void addListToMemory(String key, List<?> data) {
        if (getListFromMemCache(key) == null) {
            lruCache.put(key, data);
        }
    }

    // 从缓存中得到Text对象
    public List<?> getListFromMemCache(String key) {
        return lruCache.get(key);
    }

    // 从缓存中删除指定的Text
    public void removeTextFromMemory(String key) {
        lruCache.remove(key);
    }

}
