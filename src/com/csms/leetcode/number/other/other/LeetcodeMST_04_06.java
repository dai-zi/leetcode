package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.Stack;

//后继者
//中等
public class LeetcodeMST_04_06 {
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        boolean outFlag = false;
        while (cur != null || ! stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (outFlag) {
                    return cur;
                }
                if(cur == p) {
                    outFlag = true;
                }
                cur = cur.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
    }
}