package com.csms.leetcode.classification.binarytree;

import com.csms.leetcode.common.TreeNode;

public class BuildTree {
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTreeHelp(0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTreeHelp(int pre_begin, int pre_end, int in_begin, int in_end) {
        //不考虑异常数据
        if(pre_begin == pre_end){
            return null;
        }else if(pre_begin == pre_end - 1){
            return new TreeNode(preorder[pre_begin]);
        }
        TreeNode root = new TreeNode(preorder[pre_begin]);
        int index = 0;
        while(inorder[index] != preorder[pre_begin]){
            index++;
        }
        root.left = buildTreeHelp(pre_begin + 1, pre_begin + 1 + index - in_begin, in_begin, index);
        root.right = buildTreeHelp(pre_begin + 1 + index - in_begin, pre_end, index + 1, in_end);
        return root;
    }
}
