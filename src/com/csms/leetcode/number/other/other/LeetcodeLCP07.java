package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//传递信息
//简单
public class LeetcodeLCP07 {
private int count;
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] temp : relation){
            if(!map.containsKey(temp[0]))
                map.put(temp[0], new ArrayList<>());
            map.get(temp[0]).add(temp[1]);
        }
        count = 0;
        backTracking(map, k, n, 0, 0);
        return count;
    }

    private void backTracking(Map<Integer, List<Integer>> map, int k, int n, int cur, int curPerson){
        if(cur == k){
            if(curPerson == n - 1)
                count++;
            return;
        }
        if(!map.containsKey(curPerson))
            return;
        for(int i : map.get(curPerson)){
            backTracking(map, k, n, cur + 1, i);
        }
    }
    public static void main(String[] args) {
    }
}