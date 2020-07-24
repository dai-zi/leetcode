package com.csms.leetcode.number.n1300.n1340;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//检查整数及其两倍数是否存在
//简单
public class Leetcode1346 {
public boolean checkIfExist(int[] arr) {
    Arrays.sort(arr); // 负数...0...0...正数
    Set<Integer> set = new HashSet<>();
    for (int value : arr) {
        if (value <= 0) continue; // 只对非负数
        if (set.contains(value)) return true;
        set.add(value * 2);
    }
    set.clear();
    for (int i = arr.length - 1; i >= 0; i--) {
        if (arr[i] > 0) continue; // 只对负数
        if (set.contains(arr[i])) return true;
        set.add(arr[i] * 2);
    }
    return false;
}
    public static void main(String[] args) {
    }
}