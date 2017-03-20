package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static<T> ArrayList<T> newArrayList(T... elements) {

        ArrayList<T> list1 = new ArrayList<>();

        for (T value: elements
             ) {
            list1.add(value);
        }
        return list1;
    }

    public static<T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> list2 = new HashSet<>();

        for (T value: elements
                ) {
            list2.add(value);
        }
        return list2;
    }

    public static<K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if(keys.size()!=values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
