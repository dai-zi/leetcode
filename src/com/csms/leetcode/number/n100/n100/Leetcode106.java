package com.csms.leetcode.number.n100.n100;

import com.csms.leetcode.common.TreeNode;

//从中序与后序遍历序列构造二叉树
//中等
public class Leetcode106 {
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTreeHelpInAndPost(0, inorder.length, 0, postorder.length);
    }

    public TreeNode buildTreeHelpInAndPost(int in_begin, int in_end, int post_begin, int post_end) {
        //不考虑异常数据
        if(post_begin == post_end){
            return null;
        }else if(post_begin == post_end - 1){
            return new TreeNode(postorder[post_begin]);
        }
        TreeNode root = new TreeNode(postorder[post_end-1]);
        int index = in_begin;
        while(inorder[index] != postorder[post_end-1]){
            index++;
        }
        root.left = buildTreeHelpInAndPost(in_begin, index, post_begin, post_begin + index - in_begin);
        root.right = buildTreeHelpInAndPost(index + 1, in_end, post_begin + index - in_begin, post_end - 1);
        return root;
    }
    public static void main(String[] args) {
    }
}