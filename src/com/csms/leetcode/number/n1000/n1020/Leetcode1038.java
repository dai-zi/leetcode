package com.csms.leetcode.number.n1000.n1020;

import com.csms.leetcode.common.TreeNode;

//从二叉搜索树到更大和树
//中等
public class Leetcode1038 {
int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root != null){
            bstToGst(root.right);
            sum = sum + root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;

    }

    public static void main(String[] args) {
    }
}