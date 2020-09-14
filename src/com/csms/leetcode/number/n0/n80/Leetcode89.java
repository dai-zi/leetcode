package com.csms.leetcode.number.n0.n80;

import java.util.ArrayList;
import java.util.List;

//格雷编码
//中等
public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}