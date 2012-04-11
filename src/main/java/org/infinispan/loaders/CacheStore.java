package org.infinispan.loaders;

import javax.cache.CacheWriter;

/**
 * The new Infinispan CacheStore interface.
 *
 * @author Manik Surtani
 * @since 6.0
 */
public interface CacheStore<K, V> extends CacheWriter<K, V> {

   void clear() throws CacheLoaderException;

   void purgeExpired() throws CacheLoaderException;

}
