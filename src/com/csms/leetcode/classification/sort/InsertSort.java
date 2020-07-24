package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class InsertSort {
    public static void sort(int[] arr){
        int len = arr.length;
        for(int i = 1;i<len;i++){
            if(arr[i]<arr[i-1]){//如果有逆序，则向前找到一个不大于该值的位置，插到它后面
                int temp = arr[i];//保存当前值
                int j;
                //向前寻找
                for(j = i-1;j>=0&&arr[j]>temp;j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;//赋值
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void sortByList(ListNode head){
        if(head == null || head.next == null) return;
        ListNode pStart = new ListNode(0);//添加辅助的头节点
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
            if(nums[i]<nums[i-1]){//如果有逆序，则向前找到一个不大于该值的位置，插到它后面
                int temp = nums[i];//记录当前值
                int low = 0,h = i-1,mid=0;//二分查找的low,high,mid位置标记
                while(low<=h){
                    mid = (low+h)/2;
                    if(temp>nums[mid]){//如果当前值大于中间位置的值，则区间改为[mid+1,h]
                        low = mid+1;
                    }else{//如果当前值小于中间位置的值，则区间改为[low,mid-1]
                        h = mid-1;
                    }
                }
                //找到位置（就是low）后，从后向前移动数组，以腾出位置
                for(int j = i;j>low;j--){
                    nums[j] = nums[j-1];
                }
                nums[low] = temp;//赋值
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
