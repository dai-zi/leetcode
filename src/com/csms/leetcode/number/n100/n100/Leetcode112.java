package com.csms.leetcode.number.n100.n100;

import com.csms.leetcode.common.TreeNode;

//路径总和
//简单
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
    }
}