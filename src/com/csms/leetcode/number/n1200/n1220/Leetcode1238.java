package com.csms.leetcode.number.n1200.n1220;

import java.util.ArrayList;
import java.util.List;

//循环码排列
//中等
public class Leetcode1238 {
boolean[] marked;
    int len;
    boolean flag;
    List<Integer> ans;
    public List<Integer> circularPermutation(int n, int start) {
        len = 1 << n;
        marked = new boolean[len];
        flag = false;
        ans = new ArrayList<>();
        dfs(start, 0, n);
        return ans;
    }

    public void dfs(int val, int index, int n) {
        if (index == len) {
            flag = true;
            return;
        }
        if (marked[val]) {
            return;
        }
        marked[val] = true;
        ans.add(val);
        int num = val;
        for (int i = 0; i < n; i++) {
            int t = num & 1;
            int next;
            if (t == 0) {
                next = val + (1 << i);
            } else {
                next = val - (1 << i);
            }
            dfs(next, index + 1, n);
            if (flag) {
                return;
            }
            num >>= 1;
        }
    }

    public static void main(String[] args) {
    }
}