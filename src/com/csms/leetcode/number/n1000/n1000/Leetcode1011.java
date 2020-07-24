package com.csms.leetcode.number.n1000.n1000;
//在D天内送达包裹的能力
//中等
public class Leetcode1011 {
/**
    * 从载重x开始循环，x为数组最大的
    *
    * @param weights
    * @param d
    * @return
    */
//private int traverseSolution(int[] weights, int d) {
//    int maxLoad = findMaxWeight(weights);
//    while (greaterThenD(maxLoad, weights, d)) {
//        maxLoad++;
//    }
//    return maxLoad;
//}

private boolean greaterThenD(int maxLoad, int[] weights, int d) {
    int curLoad = maxLoad;
    for (int weight : weights) {
        if (d <= 0) {
            return true;
        }

        curLoad -= weight;
        while (curLoad < 0) {
            curLoad = maxLoad - weight;
            d--;
        }
    }
    return d <= 0;
}

    public static void main(String[] args) {
    }
}