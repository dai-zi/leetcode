package com.csms.leetcode.classification.perm;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ��һ�����ݣ� 2��1�� 2��2�� ���������� 2��4
 *
 * д�����ҵ�����һ�����У� ʹ��2��1֮����һ�����֣� 2��2��֮��������2��һֱ��2��4֮����4������
 *
 * ����41312432
 */
public class Test {
    public static void perm(int[] nums){
        permHelp(nums, 0);
    }

    private static void permHelp(int[] c,int index) {
        if(!judgeNew(Arrays.copyOf(c, index))){
            return;
        }
        //��ӡ��ǰ����
        if(index>=c.length){
            for(int i=0;i<c.length;i++)
                System.out.print(c[i]+" ");
            System.out.print("\n");
        }
        //���н����͵ݹ�
        for(int i=index;i<c.length;i++){
            swap(c,index,i);
            permHelp(c,index+1);
            swap(c,index,i);
        }
    }
    //����������ֵ����
    private static void swap(int[] c,int index1,int index2){
        int t=c[index1];
        c[index1]=c[index2];
        c[index2]=t;
    }



    public static boolean judge(int[] nums){

        for(int i = 0; i < nums.length; i++){
            boolean res = judgeOneNumber(nums, nums[i]);
            if(!res){
                return false;
            }
        }
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
        return true;
    }
    public static boolean judgeOneNumber(int[] nums,int target){
        int start = -1, end = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target && start == -1){
                start = i;
            }else if(nums[i] == target && start != -1){
                end = i;
            }
        }
        if(end - start == target + 1){
            return true;
        }
        return false;
    }

    public static boolean judgeNew(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(map.containsKey(val)){
                continue;
            }else{
                map.put(val,1);
            }
            if((i + val + 1 < nums.length && nums[i + val + 1] != val)){
                return false;
            }
            if(i + val + 1 >= 18){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
        perm(nums);
        //judge(nums);
    }
}
