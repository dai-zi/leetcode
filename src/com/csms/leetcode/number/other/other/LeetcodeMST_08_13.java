package com.csms.leetcode.number.other.other;

import java.util.Arrays;

//堆箱子
//困难
public class LeetcodeMST_08_13 {
    public int pileBox(int[][] box) {
        int len = box.length;
        Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);
        int[] dp_val = new int[len];
        dp_val[0] = box[0][2];
        int res = dp_val[0];
        for (int i = 1; i < len; ++i) {
            int max_val = 0, base_depth = box[i][1], base_height = box[i][2];
            for (int j = 0; j < i; ++j)
                if (base_depth > box[j][1] && base_height > box[j][2])
                    max_val = Math.max(max_val, dp_val[j]);

            dp_val[i] = max_val + base_height;
            res = Math.max(res, dp_val[i]);
        }
        return res;
    }
    public static void main(String[] args) {
    }
}