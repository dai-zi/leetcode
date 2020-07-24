package com.csms.leetcode.classification.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List res = new ArrayList();
        Arrays.sort(nums);
        int min = nums[0], max = nums[nums.length - 1];
        int[] map = new int[max-min+1];

        for (int num : nums) {
            map[num-min]++;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0) {
                break;
            }
            if (i>0 && n == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int m = nums[j];
                if(j>i+1 && m==nums[j-1]){
                    continue;
                }
                int x = 0 - m - n;
                if (x < m || x>max) {
                    continue;
                }
                if(map[x-min] ==0){
                    continue;
                }
                int c = 1;
                if (x == m) {
                    c++;
                }
                if (x == n) {
                    c++;
                }
                if (map[x-min] >= c) {
                    ArrayList<Object> l = new ArrayList<>();
                    l.add(n);
                    l.add(m);
                    l.add(x);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
