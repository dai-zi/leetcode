package com.csms.leetcode.number.n1300.n1340;

import java.util.*;

//跳跃游戏IV
//困难
public class Leetcode1345 {
    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        Map<Integer, Set<Integer>> value2Index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            value2Index.computeIfAbsent(arr[i], k -> new HashSet<>()).add(i);
        }

        int minStep = 0;
        Set<Integer> hasReached = new HashSet<>();
        Queue<Integer> nextStep = new LinkedList<>();
        nextStep.add(arr.length-1);
        hasReached.add(arr.length-1);
        while (!nextStep.isEmpty()) {
            int count = nextStep.size();
            minStep++;
            for (int i = 0; i < count; i++) {
                int index = nextStep.poll();
                value2Index.get(arr[index]).remove(index);
                Set<Integer> temp = new HashSet<>(value2Index.get(arr[index]));
                if (index - 1 >= 0) {
                    temp.add(index-1);
                }
                if (index + 1 < arr.length) {
                    temp.add(index + 1);
                }
                for (int a : temp) {
                    if (a == 0) {
                        return minStep;
                    }
                    if (!hasReached.contains(a)) {
                        hasReached.add(a);
                        nextStep.add(a);
                    }
                }
            }
        }
        return minStep;
    }
    public static void main(String[] args) {
    }
}