package com.csms.leetcode.number.n1300.n1360;

import com.csms.leetcode.common.TreeNode;

import java.util.LinkedList;

//找出克隆二叉树中的相同节点
//中等
public class Leetcode1379 {
// 0 for left,1 for right
    LinkedList<Integer> path ;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.path = new LinkedList<>();
        findPath(original,target);
        TreeNode ptr = cloned;
        while (!path.isEmpty()){
            int e = path.removeFirst();
            if(e == 0){
                ptr = ptr.left;
            }else {
                ptr = ptr.right;
            }
        }
        return ptr;
    }
    
    public boolean findPath(final  TreeNode root, final TreeNode target){
        if(root == null) return false;
        if(root == target) return true;
        this.path.add(0);
        if(findPath(root.left,target)) return true;
        this.path.removeLast();
        this.path.add(1);
        if(findPath(root.right,target)) return true;
        this.path.removeLast();
        return false;
    }

    public static void main(String[] args) {
    }
}