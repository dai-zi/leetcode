package com.csms.leetcode.number.n1200.n1280;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//划分数组为连续数字的集合
//中等
public class Leetcode1296 {
public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>(len);
        for (int i = 0; i < len; ++i)
            map.computeIfAbsent(nums[i], unused -> new LinkedList<>()).addLast(i);
        boolean[] selected = new boolean[len];
        while (!map.isEmpty()) {
            for (int i = 0; i < len; ++i)
                if (!selected[i]) { //当前下标的值未被使用，则将其作为起点。
                    selected[i] = true; //将当前下标的值标记为 已使用
                    //操作map，模拟“标记当前下标的值 已使用”
                    LinkedList<Integer> list = map.get(nums[i]);
                    list.removeFirst();
                    if (list.isEmpty()) map.remove(nums[i]);

                    for (int j = 1; j < k; ++j) {
                        list = map.get(nums[i] + j);
                        if (list == null) return false; //在未使用的数中，nums[i] + j不存在。
                        selected[list.removeFirst()] = true;
                        if (list.isEmpty())
                            map.remove(nums[i] + j);
                    }
                }
        }
        return true;
    }
    public static void main(String[] args) {
    }
}