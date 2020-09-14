package com.csms.leetcode.number.n400.n440;

import com.csms.leetcode.common.TreeNode;

//删除二叉搜索树中的节点
//中等
public class Leetcode450 {
    //di gui
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {     // 递归到 root 为 null ，说明找不到要删的节点
            return root;
        }
        if (key < root.val) {           // 要删的节点在左子树，删完保持BST特性
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {    // 要删的节点在右子树，删完保持BST特性
            root.right = deleteNode(root.right, key);
        } else {                        // 找到了要删除的节点
            if (root.left == null && root.right == null) {  // 如果是叶子节点，删了返回null给其父节点即可
                return null;
            } else if (root.left != null && root.right == null) {   // 如果左不空而右空，父节点继承它的左子树即可
                return root.left;
            } else if (root.left == null && root.right != null) {   // 如果右不空而左空，父节点继承它的右子树即可
                return root.right;
            } else {                                    // 左右都不空，在右子树寻找一个节点继承左子树
                TreeNode last = null;                   // 在右子树继承root.left子树的节点
                TreeNode currentRoot = root.right;      // 进入右子树
                while (currentRoot != null) {
                    last = currentRoot;
                    currentRoot = currentRoot.left;     // 一直往左走，走到空
                }
                last.left = root.left;      // 继承
                return root.right;          // 父节点继承修改后得到新子树
            }
        }
        return root;
    }

    //
    TreeNode keyFather = null;  // 要删除节点的父节点
    TreeNode keyNode = null;    // 要删除的节点
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {     // 空的BST
            return null;
        }
        findKey(root, key);         // 查找
        if (keyNode == null) {      // 找不到要删的节点
            return root;
        }
        if (keyFather == null) {    // 删的是根节点
            if (keyNode.left == null && keyNode.right == null) {            // 没有可替代的选择
                return null;
            } else if (keyNode.left != null && keyNode.right == null) {     // 左子树不空，右子树空
                return keyNode.left;
            } else if (keyNode.left == null && keyNode.right != null){      // 右子树不空，左子树空
                return keyNode.right;
            } else {        // 左右子树都不为空
                TreeNode last = null;
                keyNode = keyNode.right;
                while (keyNode != null) {
                    last = keyNode;
                    keyNode = keyNode.left;
                }
                last.left = root.left;
                return root.right;
            }
        } else {    // 删的不是根节点
            if (keyNode.left == null && keyNode.right == null) {    // 删的是叶子节点
                if (keyFather.left == keyNode) {
                    keyFather.left = null;
                } else {
                    keyFather.right = null;
                }
            } else if (keyNode.left != null && keyNode.right == null) {     // 删除节点的左子树不空，右子树为空
                if (keyNode == keyFather.left) {    // 删除节点是父节点的左子节点
                    keyFather.left = keyNode.left;
                } else {                            // 删除节点是父节点的右子节点
                    keyFather.right = keyNode.left;
                }
            } else if (keyNode.left == null && keyNode.right != null) {     // 删除节点的右子树不空，左子树为空
                if (keyNode == keyFather.left) {    // 删除节点是父节点的左子节点
                    keyFather.left = keyNode.right;
                } else {                            // 删除节点是父节点的右子节点
                    keyFather.right = keyNode.right;
                }
            } else {    // 删除节点的左右子树都不为空

                TreeNode last = null;
                TreeNode currentRoot = keyNode.right;
                while (currentRoot != null) {
                    last = currentRoot;
                    currentRoot = currentRoot.left;
                }
                last.left = keyNode.left;
                // 继承
                if (keyNode == keyFather.left) {
                    keyFather.left = keyNode.right;
                } else {
                    keyFather.right = keyNode.right;
                }
            }
        }
        return root;
    }

    // 利用BST特性查找要删除的节点
    public void findKey(TreeNode root, int key) {
        TreeNode father = null;
        TreeNode currentRoot = root;
        while (currentRoot != null) {
            if (key == currentRoot.val) {
                break;
            } else {
                father = currentRoot;
                if (key < currentRoot.val) {
                    currentRoot = currentRoot.left;
                } else {
                    currentRoot = currentRoot.right;
                }
            }
        }
        // 记录
        keyFather = father;
        keyNode = currentRoot;
    }
    public static void main(String[] args) {
    }
}