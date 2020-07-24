package com.csms.leetcode.classification.binarytree;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(p != null || s.size() > 0){
            if(p != null){
                res.add(p.val);
                if(p.right != null) {
                    s.push(p.right);
                }
                p = p.left;
            }else{
                p = s.pop();
            }
        }
        return res;
    }
}
