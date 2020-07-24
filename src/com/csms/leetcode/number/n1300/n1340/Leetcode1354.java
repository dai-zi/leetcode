package com.csms.leetcode.number.n1300.n1340;

import java.util.Comparator;
import java.util.PriorityQueue;

//多次求和构造目标数组
//困难
public class Leetcode1354 {
    private PriorityQueue<Long> q;
    private long sum = 0;

    public boolean isPossible(int[] target) {
        if (target.length == 1 && target[0] == 1) return true;
        if (target.length == 1) return false;
        initialize(target);
        while (!q.isEmpty()) {
            long previousSum = q.poll();
            long othersSum = sum - previousSum;
            long previousVal;
            long base = (!q.isEmpty() ? q.peek() : 1);
            do {
                previousVal = previousSum - othersSum;
                previousSum = previousVal;
            } while (previousVal > base);

            if (!q.isEmpty()) {
                if (previousVal == base || previousVal < 1) return false;
                sum = previousVal + othersSum;
                if (previousVal == 1) continue;
                q.offer(previousVal);
            } else {
                return previousVal == base;
            }
        }
        return true;
    }

    private void initialize(int[] target) {
        q = new PriorityQueue<>(target.length, Comparator.reverseOrder());
        for (long value : target) {
            sum += value;
            if (value > 1)
                q.offer(value);
        }
    }
    public static void main(String[] args) {
    }
}