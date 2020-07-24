package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

//检查平衡性
//简单
public class LeetcodeMST_04_04 {
public boolean isBalanced(TreeNode root) {
          
          return dfs(root);
         // dfs(root.left);
        //  dfs(root.right);

    }
    private  boolean dfs(TreeNode node){
        if (node == null){
            return true;
        }
        if (Math.abs(depth(node.left)-depth(node.right))>1){
              return false;
        }
       
        return dfs(node.right) && dfs(node.left);
    }
    private int depth(TreeNode node){
          if (node==null)
              return 0;
          return Math.max(depth(node.left),depth(node.right))+1;
    }

    public static void main(String[] args) {
    }
}