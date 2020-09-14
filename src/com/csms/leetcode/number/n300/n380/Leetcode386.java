package com.csms.leetcode.number.n300.n380;

import java.util.ArrayList;
import java.util.List;

//字典序排数
//中等
public class Leetcode386 {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i ++){
            dfs(n, i);
        }
        return res;
    }
    private void dfs(int n, int cur){
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i < 10; i ++) {
            dfs(n, cur * 10 + i);
        }
    }

    public static void main(String[] args) {
    }
}