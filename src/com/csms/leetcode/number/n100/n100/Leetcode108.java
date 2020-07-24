package com.csms.leetcode.number.n100.n100;

import com.csms.leetcode.common.TreeNode;

//将有序数组转换为二叉搜索树
//简单
public class Leetcode108 {
    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
    public static void main(String[] args) {
    }
}