package com.csms.leetcode.number.n400.n400;

import com.csms.leetcode.common.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

//左叶子之和
//简单
public class Leetcode404 {
    private int sumOfLeftLeaves2(TreeNode root){
        if(root == null) return 0;
        int res = 0;
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        stack.add(new Pair<>(root, false));
        while (!stack.isEmpty()){
            Pair<TreeNode, Boolean> pair = stack.pop();
            TreeNode node = pair.getKey();
            if(node.left != null)
                stack.add(new Pair<>(node.left, true));
            if(node.right != null)
                stack.add(new Pair<>(node.right, false));
            if(node.left == null && node.right == null && pair.getValue())
                res += node.val;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}