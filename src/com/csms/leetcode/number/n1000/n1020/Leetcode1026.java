package com.csms.leetcode.number.n1000.n1020;

import com.csms.leetcode.common.TreeNode;

//节点与其祖先之间的最大差值
//中等
public class Leetcode1026 {
public int res = 0; //保存节点和祖先节点之间的最大差值
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }
    
    private void dfs(TreeNode root, int maxV, int minV){
        if(root==null)
            return;
        maxV = Math.max(maxV, root.val);//更新该节点子节点的 祖先节点的最大val和最小val
        minV = Math.min(minV, root.val);
        int res1 = Math.max(Math.abs(root.val-maxV), Math.abs(root.val-minV));
        res = Math.max(res, res1);
        dfs(root.left, maxV, minV);
        dfs(root.right, maxV, minV);
    }
    public static void main(String[] args) {
    }
}