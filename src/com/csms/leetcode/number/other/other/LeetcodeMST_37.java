package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//序列化二叉树
//困难
public class LeetcodeMST_37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        queue.add(root);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.remove();
            if(null == cur){
                res.add("null");
                continue;
            }else {
                res.add(String.valueOf(cur.val));
            }
            //System.out.println(cur.val);
            queue.add(cur.left);
            queue.add(cur.right);
        }
        int end = res.size() - 1;
        while("null".equals(res.get(end))){
            end--;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(res.get(0));
        for(int i = 1; i <= end; i++){
            sb.append("," + res.get(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cnt = 1;
        int leafs = 0;
        TreeNode cur = null;
        while(cnt<nodes.length){
            cur = queue.peek();
//            TreeNode tmp = null;
//            if(!"null".equals(nodes[cnt])){
//                tmp = new TreeNode(Integer.valueOf(nodes[cnt]));
//            }
            if(leafs == 0){
                if(!"null".equals(nodes[cnt])){
                    cur.left = new TreeNode(Integer.valueOf(nodes[cnt]));
                    queue.add(cur.left);
                }
                leafs++;
            }else if(leafs == 1){
                if(!"null".equals(nodes[cnt])){
                    cur.right = new TreeNode(Integer.valueOf(nodes[cnt]));
                    queue.add(cur.right);
                }

                leafs = 0;
                queue.remove();
            }
            cnt++;
        }
        return root;
    }
    public static void main(String[] args) {
    }
}