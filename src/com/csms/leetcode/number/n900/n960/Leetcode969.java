package com.csms.leetcode.number.n900.n960;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//煎饼排序
//中等
public class Leetcode969 {
public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }
    public static void main(String[] args) {
    }
}