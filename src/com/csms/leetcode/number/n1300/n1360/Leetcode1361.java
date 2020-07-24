package com.csms.leetcode.number.n1300.n1360;

import com.csms.leetcode.common.ListNode;
import com.csms.leetcode.common.Node;
import com.csms.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//验证二叉树
//中等
public class Leetcode1361 {
public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //1、先构造一个二叉树的问题
        // A处：构造时注意自环，
        // B处：以及同一结点的二次new(),利用hashmap判重，保证同一个结点只被new一次
        HashMap<Integer, TreeNode> map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            if (i == leftChild[i] || i == rightChild[i]) return false;//A
            TreeNode root = map.get(i);
            if (root == null)//B
                root = new TreeNode(i);
            if (leftChild[i] != -1) {
                root.left = map.get(leftChild[i]);
                if (root.left == null) {//B
                    root.left = new TreeNode(leftChild[i]);
                    map.put(leftChild[i], root.left);
                }
            }
            if (rightChild[i] != -1) {
                root.right = map.get(rightChild[i]);
                if (root.right == null) {//B
                    root.right = new TreeNode(rightChild[i]);
                    map.put(rightChild[i], root.right);
                }
            }
            map.put(i, root);
        }
        boolean rst = false;
        //2、BFS自顶向下搜索
        //C处:判断是否存在回路 或 一个子节点同时被两上父节点指向
        //D处：默认是根节点不一定是0,可以是别的节点，所以需要遍历
        for (Integer key : map.keySet()) {//D
            TreeNode root = map.get(key);
            Queue<TreeNode> Q = new LinkedList<>();
            Q.add(root);
            boolean F[] = new boolean[n];
            while (!Q.isEmpty()) {
                root = Q.remove();
                if (F[root.val]) return false;//C
                F[root.val] = true;
                if (root.left != null) Q.add(root.left);
                if (root.right != null) Q.add(root.right);
            }
            int i = 0;
            for (; i < F.length; ++i) {
                if (!F[i]) break;
            }
            if (i == F.length) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
    }
}


