package com.csms.leetcode.classification.dp;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int[] min = new int[triangle.get(triangle.size() - 1).size()];
        for(int i = 0; i < min.length; i++){
            min[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i = triangle.size() -2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j+1]);
            }
        }
        int res = min[0];
        return min[0];
    }
}
