package com.csms.leetcode.number.n1300.n1380;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//四因数
//中等
public class Leetcode1390 {
public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int item : nums) {
            result += sum(item);
        }

        return result;
    }

    private int sum(int num) {
        List<Integer> list = new ArrayList<>();
        int count = (int) Math.sqrt(Math.abs(num));
        for (int i = 1; i <= count; i++) {
            if (num % i == 0 && !list.contains(i)) {
                list.add(i);
                list.add(num / i);
            }
        }

        List<Integer> result = list.stream().distinct().collect(Collectors.toList());

        if (result.size() == 4) return list.stream().distinct().mapToInt(o -> o).sum();

        return 0;
    }

    public static void main(String[] args) {
    }
}