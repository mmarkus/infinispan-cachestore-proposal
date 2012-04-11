package org.infinispan.loaders;

import javax.transaction.Transaction;

/**
 * Implement this if your cache store implementation is XA compliant and can register with an XA transaction manager.
 *
 * @author Manik Surtani
 * @since 5.1
 */
public interface TransactionalCacheStore<K, V> extends CacheStore<K, V> {

   void enlist(Transaction transaction);

}
