package com.csms.leetcode.number.n1300.n1340;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//最多可以参加的会议数目
//中等
public class Leetcode1353 {
public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[1] - o2[1]);
        Set<Integer> set = new HashSet<>();
        for (int[] event : events) {
            int s = event[0];
            int e = event[1];
            for (int i = s; i <=e; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
    }
}