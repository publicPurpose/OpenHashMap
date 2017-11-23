package com.ua.task;

import java.util.Collections;

/**
 * Created by User on 11/23/2017.
 */
public class Run {
    public static void main(String[] args) {
        OpenHashMap hashMap = new OpenHashMap(16);
        hashMap.put(12, 455555555);
        hashMap.put(12, 4);
        hashMap.put(16, 7);
        hashMap.put(45, 45);

        System.out.println(Collections.singletonList(hashMap));

        System.out.println(hashMap.getValue(12));
        System.out.println(hashMap.getValue(16));
        System.out.println(hashMap.getValue(458));
    }
}
