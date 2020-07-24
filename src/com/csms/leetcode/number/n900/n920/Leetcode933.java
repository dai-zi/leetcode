package com.csms.leetcode.number.n900.n920;

import java.util.LinkedList;
import java.util.Queue;

//最近的请求次数
//简单
public class Leetcode933 {
Queue<Integer> q;
    public Leetcode933() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }

    public static void main(String[] args) {
    }
}