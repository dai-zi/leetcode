package com.csms.leetcode.number.n1200.n1200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//独一无二的出现次数
//简单
public class Leetcode1207 {
public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        // 记录出现次数
        for(int data :arr) {
            if (map.get(data) == null) map.put(data, 1);
            else map.put(data, map.get(data) + 1);
        }
        
        // 验证重复值
        for(Integer i : map.values()) {
            if (!set.add(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
    }
}