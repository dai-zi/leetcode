package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.Stack;

//合法二叉搜索树
//中等
public class LeetcodeMST_04_05 {
public boolean isValidBST(TreeNode root) {
       Stack<TreeNode> stack = new Stack<TreeNode>();
        Integer curValue = null;
        TreeNode cur = root;
        while (cur != null || ! stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if(curValue != null && cur.val <= curValue) {
                    return false;
                }
                curValue = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}