package com.csms.leetcode.number.other.other;

import java.util.Collections;
import java.util.PriorityQueue;

//数据流中的中位数
//困难
public class LeetcodeMST_41 {
    private PriorityQueue<Integer> maxHeap, minHeap;

    public LeetcodeMST_41() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        //如果不平衡则调整
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
        return maxHeap.peek();
    }
    public static void main(String[] args) {
    }
}