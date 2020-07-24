package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.Arrays;

//最小高度树
//简单
public class LeetcodeMST_04_02 {
public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        TreeNode n = new TreeNode(nums[nums.length/2]);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return n;
    }
    public static void main(String[] args) {
    }
}