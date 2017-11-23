package com.ua.task;

import java.util.Arrays;

public class OpenHashMap {
    private int FREE = Integer.MIN_VALUE;
    private int initSize;
    private int[] keys;
    private long[] values;
    private int count;

    public OpenHashMap(int initSize) {
        this.initSize = initSize + 1;
        keys = new int[this.initSize];
        values = new long[this.initSize];
        this.count = 0;
        Arrays.fill(keys, FREE);
    }

    //add couple k-v
    void put(int x, long y) {
        for (int i = index(hash(x)); ; i++) {
            if (keys[i] == FREE)
                keys[i] = x;
            if (keys[i] == x) {
                values[i] = y;
                count ++;
                return;
            }
        }
    }

    // getValue value
    long getValue(int x) {
        for (int i = index(hash(x)); ; i++) {
            if (i == initSize) i = 0;
            if (keys[i] == FREE) throw new RuntimeException("no such key presented");
            if (keys[i] == x) return values[i];
        }
    }

    // returns number of element put in our hasMap
    int size() {
        return count;
    }

    private int hash(int x) {
        return (x >> 15) ^ x;
    }

    private int index(int hash) {
        return Math.abs(hash) % initSize;
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
