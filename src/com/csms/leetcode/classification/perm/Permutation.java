package com.csms.leetcode.classification.perm;

public class Permutation {
    public static void perm(int n){

    }

    public static void perm(int[] nums){
        permHelp(nums, 0);
    }

    private static void permHelp(int[] c,int index) {
        //打印当前序列
        if(index>=c.length){
            for(int i=0;i<c.length;i++)
                System.out.print(c[i]+" ");
            System.out.print("\n");
        }
        //进行交换和递归
        for(int i=index;i<c.length;i++){
            swap(c,index,i);
            permHelp(c,index+1);
            swap(c,index,i);
        }
    }
    //数组里两个值交换
    private static void swap(int[] c,int index1,int index2){
        int t=c[index1];
        c[index1]=c[index2];
        c[index2]=t;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        perm(nums);
    }
}
