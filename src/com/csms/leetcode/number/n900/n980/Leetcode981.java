package com.csms.leetcode.number.n900.n980;

import javafx.util.Pair;

import java.util.*;

//基于时间的键值存储
//中等
public class Leetcode981 {
Map<String, List<Pair<Integer, String>>> M;

    public Leetcode981() {
        M = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new ArrayList<Pair<Integer, String>>());

        M.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";

        List<Pair<Integer, String>> A = M.get(key);
        int i = Collections.binarySearch(A, new Pair<Integer, String>(timestamp, "{"),
                (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        if (i >= 0)
            return A.get(i).getValue();
        else if (i == -1)
            return "";
        else
            return A.get(-i-2).getValue();
    }

    public static void main(String[] args) {
    }
}