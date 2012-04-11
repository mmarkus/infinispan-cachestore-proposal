package org.infinispan.loaders;

import org.infinispan.loaders.modifications.Modification;
import org.infinispan.transaction.xa.GlobalTransaction;

/**
 * Implement this if your cache store does not have native XA capabilities.  Infinispan will then act as a transactional
 * proxy for the cache store and call the required transaction lifecycle callbacks when needed.
 *
 * @author Manik Surtani
 * @since 6.0
 */
public interface NonTransactionalCacheStore<K, V> extends CacheStore<K, V> {

   void prepare(java.util.List<? extends Modification> modifications, GlobalTransaction transactionIdentifier, boolean b) throws CacheLoaderException;

   void commit(GlobalTransaction transactionIdentifier) throws CacheLoaderException;

   void rollback(GlobalTransaction transactionIdentifier);
}
