package com.csms.leetcode.number.n1400.n1440;

import com.csms.leetcode.common.TreeNode;

//二叉树中的伪回文路径
//中等
public class Leetcode1457 {
int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return ans;
    }
    
    void helper(TreeNode node,int temp){
        temp^=(1<<node.val);//node节点的val为几就左移几位
        if(node.left==null&&node.right==null){//判断是否叶子节点
            if(temp==0||(temp&(temp-1))==0){//判断是否为伪回文
                ans++;
            }
        }
        if(node.left!=null) helper(node.left,temp);
        if(node.right!=null) helper(node.right,temp);
        return;
    }
    public static void main(String[] args) {
    }
}