package org.example;

import java.util.*;

public class MapDImpl<K, V> implements MapProd<K, V> {
    private final List<Pair<K, V>> entries;

    public MapDImpl(List<Pair<K, V>> entries) {
        this.entries = entries;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Pair<K, V> entry : entries) {
            if (key.equals(entry.key)) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Pair<K, V> entry : entries) {
            if (value.equals(entry.value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Pair<K, V> entry : entries) {
            if (key.equals(entry.key)) return entry.value;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        for (Pair<K, V> pair : entries) {
            if (!key.equals(pair.key)) entries.add(new Pair<>(key, value));
            else pair.value = value;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        for (Pair<K, V> entry : entries) {
            if (key.equals(entry.key)) {
                entries.remove(entry);
                return null;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<K, V> m) {
        if (m.isEmpty()) throw new IllegalArgumentException();
        for (Pair<K, V> pair : entries) {
            for (Map.Entry<K, V> entry : m.entrySet()){
                if (entry.getKey().equals(pair.key)) pair.value = entry.getValue();
                m.remove(entry.getKey());
            }
        }
        for (Map.Entry<K, V> entry : m.entrySet()) {
            entries.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public Collection<K> keys() {
        List<K> ks = new ArrayList<>();
        for (Pair<K, V> kvPair : entries) {
            ks.add(kvPair.key);
        }
        return ks;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>() {
        };
        if (!this.isEmpty()) {
            for (Pair<K, V> pair : entries) {
                values.add(pair.value);
            }
        }
        return values;
    }

    @Override
    public Set<Pair<K, V>> entrySet() {
        return new HashSet<>(entries);
    }
}
