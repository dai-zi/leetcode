package com.csms.leetcode.classification.binarytree;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null || stack.size() > 0){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                res.add(p.val);
                // if(p.right != null){
                //     stack.push(p.right);
                // }
                p = p.right;
            }
        }
        return res;
    }
}
