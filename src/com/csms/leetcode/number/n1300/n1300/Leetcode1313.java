package com.csms.leetcode.number.n1300.n1300;
//解压缩编码列表
//简单
public class Leetcode1313 {
public int[] decompressRLElist(int[] nums) {
        int z = 0;
        for(int i = 0; i < nums.length - 1; i += 2 ){
            z += nums[i];
        }
        int[] list = new int[z];
        z = 0;
        for(int i = 0; i < nums.length - 1; i += 2 ){
            int count = nums[i];
            for(int j = 0; j < count; j++){
                list[z] = (nums[i + 1]);
                z++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
    }
}