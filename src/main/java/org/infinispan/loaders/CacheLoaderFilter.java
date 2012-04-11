package org.infinispan.loaders;

/**
 * Filters which elements get loaded using a cache loader during preload
 *
 * @author Manik Surtani
 * @since 6.0
 */
public interface CacheLoaderFilter<K> {

   boolean shouldLoad(K key);

   boolean needsMoreEntries();

}
