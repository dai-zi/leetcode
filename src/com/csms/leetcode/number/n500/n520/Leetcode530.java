package com.csms.leetcode.number.n500.n520;

import com.csms.leetcode.common.TreeNode;

//二叉搜索树的最小绝对差
//简单
public class Leetcode530 {
    // 初始化最小值
    int min = Integer.MAX_VALUE;
    // 前一个节点，初始化为null
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        pre(root);
        return min;
    }
    public void pre(TreeNode root){
        if(root == null)
            return ;
        // 中序遍历
        pre(root.left);
        // 判空，寻找最小差值
        if(pre != null)
            min = Math.min(min,root.val - pre.val);
        // 将此节点设置为前一节点
        pre = root;
        pre(root.right);
    }

    public static void main(String[] args) {
    }
}