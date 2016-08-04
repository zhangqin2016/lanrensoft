package com.lz.kit.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import com.lz.tool.PathKit;

import java.io.File;
import java.util.List;

public class CacheKit {

    static {
       String path= PathKit.getRootClassPath()+ File.separator+"ehcache"+File.separator+"ehcache.xml";
        cacheManager = CacheManager.create(path);
    }
    private static  CacheManager cacheManager;
    private static volatile Object locker = new Object();

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    static Cache getOrAddCache(String cacheName) {
        Cache cache = getCacheManager().getCache(cacheName);
        if (cache == null) {
            synchronized(locker) {
                cache = getCacheManager().getCache(cacheName);
                if (cache == null) {
                    getCacheManager().addCacheIfAbsent(cacheName);
                    cache = getCacheManager().getCache(cacheName);
                }
            }
        }
        return cache;
    }

    public static void put(String cacheName, Object key, Object value) {
        getOrAddCache(cacheName).put(new Element(key, value));
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, Object key) {
        Element element = getOrAddCache(cacheName).get(key);
        return element != null ? (T)element.getObjectValue() : null;
    }

    @SuppressWarnings("rawtypes")
    public static List getKeys(String cacheName) {
        return getOrAddCache(cacheName).getKeys();
    }

    public static void remove(String cacheName, Object key) {
        getOrAddCache(cacheName).remove(key);
    }

    public static void removeAll(String cacheName) {
        getOrAddCache(cacheName).removeAll();
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, Object key, IDataLoader dataLoader) {
        Object data = get(cacheName, key);
        if (data == null) {
            data = dataLoader.load();
            put(cacheName, key, data);
        }
        return (T)data;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, Object key, Class<? extends IDataLoader> dataLoaderClass) {
        Object data = get(cacheName, key);
        if (data == null) {
            try {
                IDataLoader dataLoader = dataLoaderClass.newInstance();
                data = dataLoader.load();
                put(cacheName, key, data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (T)data;
    }
}


