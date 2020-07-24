package com.csms.leetcode.number.other.other;

import java.util.PriorityQueue;
import java.util.Queue;

//连续中值
//困难
public class LeetcodeMST_17_20 {
    /** initialize your data structure here. */
    private Queue<Integer> maxheap;
    private Queue<Integer> minheap;
    public LeetcodeMST_17_20() {
        maxheap = new PriorityQueue<>((x, y) -> y-x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxheap.size() > minheap.size()){
            maxheap.add(num);
            minheap.add(maxheap.poll());
        }else{
            minheap.add(num);
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if(maxheap.size() > minheap.size()){
            return maxheap.peek();
        }else if(minheap.size() > maxheap.size()){
            return minheap.peek();
        }else{
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
    }
    public static void main(String[] args) {
    }
}