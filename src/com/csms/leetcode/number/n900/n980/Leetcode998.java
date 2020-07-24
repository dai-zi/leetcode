package com.csms.leetcode.number.n900.n980;

import com.csms.leetcode.common.TreeNode;

//最大二叉树II
//中等
public class Leetcode998 {
public TreeNode insertIntoMaxTree(TreeNode root, int val) {
       if(root==null)
        	   return new TreeNode(val);
           else if(root==null||root.val<val){//若是自己比根节点都大，那么树变为自己的左孩子
            	TreeNode temp=new TreeNode(val);
            	temp.left=root;
            	return temp;
            }
          TreeNode  root1= root;
          TreeNode root2=root;
          while(root1!=null&&root1.val>val){
        	  if(root1.right!=null&&root1.right.val>val){
        	   root1=root1.right;//因为是最后一个数组的值，那么他必然是树的右边的节点
        	  }
        	   else{
        		   break;
        	   }
          }
          if(root1.right==null&&root1.val>val){
        	  root1.right=new TreeNode(val);//若是节点的右孩子空啦且自己比该节点小，那么好了，直接插入吧
          }
          else if(root1.right!=null&&root1.right.val<val){
        	  root2=root1.right;//否则就是自己比最后一个节点大，那么要修改指针，最后变为非叶节点，原来的一坨，变为自己的左孩子
        	  root1.right=new TreeNode(val);
        	  root1.right.left=root2;
          }
          
            return root;
    }

    public static void main(String[] args) {
    }
}