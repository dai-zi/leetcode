package com.csms.leetcode.number.n1000.n1020;

import com.csms.leetcode.common.TreeNode;

//从根到叶的二进制数之和
//简单
public class Leetcode1022 {
int result = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root,0);
        return result;
    }

    private void traverse(TreeNode root,int curr){
        if(root==null){
            return;
        }
        curr = (curr<<1)+root.val;
        if(root.left==null&&root.right==null){
            result += curr;
            return;
        }
        traverse(root.left,curr);
        traverse(root.right,curr);
        
    }
    public static void main(String[] args) {
    }
}