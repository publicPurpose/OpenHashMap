package com.ua.task;

import java.util.Arrays;

public class OpenHashMap {
    int FREE = Integer.MIN_VALUE;
    int size;
    int[] keys;
    long[] values;

    public OpenHashMap(int size) {
        this.size = size + 1;
        keys = new int[this.size];
        values = new long[this.size];
        Arrays.fill(keys, FREE);
    }

    //add couple k-v
    void put(int x, long y) {
        for (int i = index(hash(x)); ; i++) {
            if (keys[i] == FREE)
                keys[i] = x;
            if (keys[i] == x) {
                values[i] = y;
                return;
            }
        }
    }

    // getValue value
    long getValue(int x) {
        for (int i = index(hash(x)); ; i++) {
            if (i == size) i = 0;
            if (keys[i] == FREE) throw new RuntimeException("no such key presented");
            if (keys[i] == x) return values[i];
        }

    }

    int size() {
        return size;
    }

    private int hash(int x) {
        return (x >> 15) ^ x;
    }

    private int index(int hash) {
        return Math.abs(hash) % size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenHashMap{");
        sb.append("keys=").append(Arrays.toString(keys));
        sb.append(", values=").append(Arrays.toString(values));
        sb.append('}');
        return sb.toString();
    }
}
