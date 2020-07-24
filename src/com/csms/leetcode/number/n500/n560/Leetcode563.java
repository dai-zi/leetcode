package com.csms.leetcode.number.n500.n560;

import com.csms.leetcode.common.TreeNode;

//二叉树的坡度
//简单
public class Leetcode563 {
    int tilt=0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }

    public static void main(String[] args) {
    }
}