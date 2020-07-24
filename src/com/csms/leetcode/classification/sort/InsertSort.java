package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class InsertSort {
    public static void sort(int[] arr){
        int len = arr.length;
        for(int i = 1;i<len;i++){
            if(arr[i]<arr[i-1]){//�������������ǰ�ҵ�һ�������ڸ�ֵ��λ�ã��嵽������
                int temp = arr[i];//���浱ǰֵ
                int j;
                //��ǰѰ��
                for(j = i-1;j>=0&&arr[j]>temp;j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;//��ֵ
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void sortByList(ListNode head){
        if(head == null || head.next == null) return;
        ListNode pStart = new ListNode(0);//��Ӹ�����ͷ�ڵ�
        pStart = head;
        ListNode p = head.next;
        ListNode pend = head;
        while(p!=null){
            ListNode temp = pStart.next;
            ListNode pre = pStart;
            while(temp!=p&&p.val>temp.val){
                temp = temp.next;
                pre = pre.next;
            }
            if(temp == p) pend = p;
            else{
                pend.next = p.next;
                p.next = temp;
                pre.next = p;
            }
            p = pend.next;
        }
        //head = pStart.next;
        //head = pStart.next;
        head = head.next;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void insertBinarySort(int nums[]){
        int len = nums.length;
        for(int i = 1;i<len;i++){
            if(nums[i]<nums[i-1]){//�������������ǰ�ҵ�һ�������ڸ�ֵ��λ�ã��嵽������
                int temp = nums[i];//��¼��ǰֵ
                int low = 0,h = i-1,mid=0;//���ֲ��ҵ�low,high,midλ�ñ��
                while(low<=h){
                    mid = (low+h)/2;
                    if(temp>nums[mid]){//�����ǰֵ�����м�λ�õ�ֵ���������Ϊ[mid+1,h]
                        low = mid+1;
                    }else{//�����ǰֵС���м�λ�õ�ֵ���������Ϊ[low,mid-1]
                        h = mid-1;
                    }
                }
                //�ҵ�λ�ã�����low���󣬴Ӻ���ǰ�ƶ����飬���ڳ�λ��
                for(int j = i;j>low;j--){
                    nums[j] = nums[j-1];
                }
                nums[low] = temp;//��ֵ
            }
        }

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        ListNode head = new ListNode(0);
        head.next = new ListNode(6);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(1);
        sortByList(head);
        sort(arr);
        insertBinarySort(arr);
    }
}
