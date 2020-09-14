package com.csms.leetcode.number.n400.n480;

import java.util.Collections;
import java.util.PriorityQueue;

//滑动窗口中位数
//困难
public class Leetcode480 {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        //滑动窗口固定写法
        int i = 0, j = 0;
        int count = 0;
        int index = 0;  //res的下标
        for (i = 0; i < nums.length - k + 1; i++) {
            while (j < nums.length && count < k) {
                add(maxHeap, minHeap, nums[j]);
                count++;
                j++;
            }
            if (count == k) {
                if (maxHeap.size() == minHeap.size()) {
                    res[index++] = (maxHeap.peek() + minHeap.peek()) * 0.5;     //这边给[2147483647,2147483647]，这就越界了，用long～
                } else {
                    res[index++] = maxHeap.peek();
                }
            }
            count--;
            remove(maxHeap, minHeap, (double)nums[i]);
        }
        return res;
    }

    public static void add(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap, double num) {
        maxHeap.offer((double)num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        return;
    }

    public static void remove(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap, double del) {
        if (del <= maxHeap.peek()) {
            maxHeap.remove(del);
        } else {
            minHeap.remove(del);
        }
        return;
    }
    public static void main(String[] args) {
    }
}