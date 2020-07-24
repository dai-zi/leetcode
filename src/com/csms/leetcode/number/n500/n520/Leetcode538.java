package com.csms.leetcode.number.n500.n520;

import com.csms.leetcode.common.TreeNode;

//把二叉搜索树转换为累加树
//简单
public class Leetcode538 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
    }
}