package com.csms.leetcode.number.n100.n100;

import com.csms.leetcode.common.TreeNode;

//二叉树的最大深度
//简单
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
    public static void main(String[] args) {
    }
}