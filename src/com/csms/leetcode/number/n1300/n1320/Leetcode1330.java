package com.csms.leetcode.number.n1300.n1320;

import java.util.Arrays;
import java.util.Collections;

//翻转子数组得到最大的数组值
//困难
public class Leetcode1330 {
    public int maxValueAfterReverse(int[] nums) {
        int leng = nums.length;
        int f1,f2,f3,f4,g1,g2,g3,g4,sum,max,left0,right0;
        sum = max = 0;
        left0 = right0 = f1 = f2 = f3 = f4 = g1 = g2 = g3 = g4 = Integer.MIN_VALUE;

        //left = 0
        for(int i = 0;i < leng;i ++){
            if(i < leng - 1){
                left0 = Math.max(left0,
                        Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
                sum += Math.abs(nums[i] - nums[i + 1]);
                int r1v = nums[i + 1];
                int absR = Math.abs(nums[i] - r1v);
                g1 = Math.max(g1,0 - nums[i] - r1v - absR);
                g2 = Math.max(g2,0 - nums[i] + r1v - absR);
                g3 = Math.max(g3,nums[i] - r1v - absR);
                g4 = Math.max(g4,nums[i] + r1v - absR);
            }

            if(i > 0){
                right0 = Math.max(right0,
                        Math.abs(nums[i - 1] - nums[leng - 1]) - Math.abs(nums[i] - nums[i - 1]));

                int l1v = nums[i - 1];

                int absL = Math.abs(l1v - nums[i]);

                f1 = Math.max(f1,l1v + nums[i] - absL);
                f2 = Math.max(f2,l1v - nums[i] - absL);
                f3 = Math.max(f3,nums[i] - l1v - absL);
                f4 = Math.max(f4,0 - l1v - nums[i] - absL);
            }
        }

        max = Collections.max(Arrays.asList(f1 + g1,f2 + g2,f3 + g3,f4 + g4,left0,right0));


        return sum + max;
    }
    public static void main(String[] args) {
    }
}