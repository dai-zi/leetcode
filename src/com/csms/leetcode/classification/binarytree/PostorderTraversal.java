package com.csms.leetcode.classification.binarytree;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while(p != null || s.size() > 0){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.peek();
                if(p.right == pre || p.right == null){
                    res.add(p.val);
                    s.pop();
                    pre = p;
                    p = null;
                }else{
                    p = p.right;
                    pre = p;
                }
            }
        }
        return res;
    }
}
