package org.example;

import java.util.HashMap;
import java.util.Map;

public class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    V getValue() {
        return this.value;

    }

    K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
