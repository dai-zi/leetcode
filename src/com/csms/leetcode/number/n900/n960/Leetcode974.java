package com.csms.leetcode.number.n900.n960;

import java.util.HashMap;
import java.util.Map;

//和可被K整除的子数组
//中等
public class Leetcode974 {
public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
}
    public static void main(String[] args) {
    }
}