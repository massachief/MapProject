package org.example;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MapProd<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(Map <K, V> m);

    void clear();

    Collection<K> keys();

    Collection<V> values();

    Set<Pair<K, V>> entrySet();
}
