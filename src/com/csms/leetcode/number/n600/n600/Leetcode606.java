package com.csms.leetcode.number.n600.n600;

import com.csms.leetcode.common.TreeNode;

//根据二叉树创建字符串
//简单
public class Leetcode606 {
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }

    public static void main(String[] args) {
    }
}