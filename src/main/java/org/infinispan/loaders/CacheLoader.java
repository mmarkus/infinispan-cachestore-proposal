package org.infinispan.loaders;

import org.infinispan.Cache;
import org.infinispan.container.entries.InternalCacheEntry;
import org.infinispan.marshall.StreamingMarshaller;

import java.util.Set;

/**
 * The new Infinispan CacheLoader interface.
 *
 * @author Manik Surtani
 * @since 6.0
 * @see CacheStore
 * @see javax.cache.CacheLoader
 */
public interface CacheLoader<K, V> extends javax.cache.CacheLoader<K, V> {

   // TODO: Need to discuss with JSR 107 on proper lifecycle since this makes cache loaders non-portable.
   void init(CacheLoaderConfig cacheLoaderConfig, Cache<?,?> cache, StreamingMarshaller streamingMarshaller) throws CacheLoaderException;

   // TODO: Should we use Cache.Entry rather than InternalCacheEntry as per JSR 107 here?
   Set<InternalCacheEntry> loadAll() throws CacheLoaderException;

   Set<InternalCacheEntry> load(CacheLoaderFilter<K> filter) throws CacheLoaderException;

   boolean containsKey(K key) throws CacheLoaderException;

   void start() throws CacheLoaderException;

   void stop() throws CacheLoaderException;
}
