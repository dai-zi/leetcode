package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

//二叉搜索树的最近公共祖先
//简单
public class LeetcodeMST_68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else break;
        }
        return root;
    }

    public static void main(String[] args) {
    }
}