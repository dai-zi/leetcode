package com.csms.leetcode.number.n300.n380;

import java.util.Random;

//随机数索引
//中等
public class Leetcode398 {
    private int[] nums;
    public Leetcode398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int n = 0;
        int index = 0;
        for(int i = 0;i < nums.length;i++)
            if(nums[i] == target){
                //我们的目标对象中选取。
                n++;
                //我们以1/n的概率留下该数据
                if(r.nextInt() % n == 0) index = i;
            }
        return index;
    }
    public static void main(String[] args) {
    }
}