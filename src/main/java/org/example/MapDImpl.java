package org.example;

import java.util.*;

public class MapDImpl<K, V> implements MapProd<K, V> {
    private List<Pair<K, V>> entries;

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
        for (int entry = 0; entry < entries.size(); entry++) {
            if (!key.equals(entries.get(entry).key)) entries.add(new Pair<>(key, value));
            else entries.get(entry).value = value;
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
        ArrayList<K> keySet = new ArrayList<>(m.keySet());
        if (m.isEmpty()) throw new IllegalArgumentException();
        for (int entry = 0; entry < m.size(); entry++) {
            for (Pair<K, V> kvPair : entries) {
                if (keySet.get(entry).equals(kvPair.key)) {
                    kvPair.value = m.get(kvPair.key);
                    keySet.remove(entry);
                }
            }

        }
        for (int entry = 0; entry < m.size(); entry++) {
            entries.addAll((Collection<? extends Pair<K, V>>) m);
            /*entries.addAll((Collection<? extends Pair<K, V>>) m);*/

        }
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks = new HashSet<>();
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
            for (int i = 0; i < this.size(); i++) {
                values.add(this.get(i));
            }
        }
        return values;
    }

    @Override
    public Set<Pair<K, V>> entrySet() {
        return (Set<Pair<K, V>>) entries;
    }
}
