package com.csms.leetcode.number.n1400.n1460;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//重新规划路线
//中等
public class Leetcode1466 {
	public int minReorder(int n, int[][] connections) {
        List<HashSet<Integer>> in = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            in.add(new HashSet());
        }
        List<HashSet<Integer>> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            out.add(new HashSet());
        }

        for (int[] c : connections) {
            int a = c[0];
            int b = c[1];
            in.get(b).add(a);
            out.get(a).add(b);
        }

        LinkedList<Integer> queue = new LinkedList();
        queue.add(0);
        int ans = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (in.get(cur) != null && in.get(cur).size() > 0) {
                for(int k : in.get(cur)){
                    queue.add(k);
                    //出度中去清除
                    out.get(k).remove(cur);
                }
                in.get(cur).clear();
            }
            if(out.get(cur) != null && out.get(cur).size() > 0){
                for(int k : out.get(cur)){
                    ans++;
                    queue.add(k);
                    in.get(k).remove(cur);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}