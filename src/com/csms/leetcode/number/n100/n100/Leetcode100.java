package com.csms.leetcode.number.n100.n100;

import com.csms.leetcode.common.TreeNode;

//相同的树
//简单
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {
    }
}