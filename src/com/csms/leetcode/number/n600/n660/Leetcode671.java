package com.csms.leetcode.number.n600.n660;

import com.csms.leetcode.common.TreeNode;

//二叉树中第二小的节点
//简单
public class Leetcode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
    public static void main(String[] args) {
    }
}