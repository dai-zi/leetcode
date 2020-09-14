package com.csms.leetcode.number.n300.n360;

import java.util.*;

//查找和最小的K对数字
//中等
public class Leetcode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        k = Math.min(k,nums1.length*nums2.length); //注意k的取值
        if(k==0) return res;

        Queue<int[]> Q = new PriorityQueue<>(k,(o1, o2)->o2[0]+o2[1]-o1[0]-o1[1]);
        for(int e1:nums1)
            for(int e2:nums2){
                if(Q.size()<k) {
                    Q.offer(new int[]{e1,e2});
                }else if(e1+e2<=Q.peek()[0]+Q.peek()[1]){
                    Q.poll();
                    Q.offer(new int[]{e1,e2});
                }
            }
        while(k-->0){
            int[] e = Q.poll();
            res.add(0, Arrays.asList(e[0],e[1]));
        }

        return res;

    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        k = Math.min(k,nums1.length*nums2.length);
        if(k==0) return res;

        Queue<Node> Q = new PriorityQueue<>(nums1.length,
                (o1,o2)->o1.v+nums2[o1.idx]-o2.v-nums2[o2.idx]);
        for(int i=0;i<nums1.length;i++) {
            Q.offer(new Node(nums1[i],0));
        }

        while(k-->0) {
            res.add(Arrays.asList(Q.peek().v,nums2[Q.peek().idx]));
            Q.peek().idx++;
            if(Q.peek().idx==nums2.length)
                Q.poll();
            else
                Q.offer(Q.poll()); //因为Q.peek().idx更新了，需要把堆顶Node取出后再重新放入
        }

        return res;
    }
    public static void main(String[] args) {
    }
}
class Node {
    int v; //nums1的元素值
    int idx; //v对应的在nums2中的候选值索引
    public Node(int _v,int _idx) {v=_v;idx=_idx;}
}

