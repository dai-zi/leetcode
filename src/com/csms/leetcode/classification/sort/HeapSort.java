package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class HeapSort {
    public static void swap(int nums[],int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
    public static void sort(int nums[]){
        heapSort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    /**
     * 调整堆
     * @param nums
     * @param i
     * @param len
     */
    public static void adjustHeap(int nums[],int i,int len){
        int temp = nums[i];//记录当前节点值（父节点）
        //向下遍历子节点
        for(int k = 2*i+1;k<len;k = k*2+1){
            //如果存在右子节点，且右子节点大于左子节点
            if(k+1<len&&nums[k]<nums[k+1]){
                k++;//指向右子节点
            }
            //如果子节点比当前节点（父节点）大，则将子节点值赋给父节点
            if(nums[k]>temp){
                nums[i] = nums[k];
                i = k;//记录父节点的位置，最终要落到的位置
            }else{//如果子节点小于父节点，则调整结束
                break;
            }
        }
        //将当前父节点的值，最终落位入座
        nums[i] = temp;
    }
    /**
     * 堆排序，升序，最大堆
     * 通过不断把根节点（最大值）放到最后一个节点处，
     * 实现数组从小到大排序
     * @param nums
     */
    public static void heapSort(int nums[]){
        int len = nums.length;
        // build heap
        for(int i = len/2-1;i>=0;i--){
            //从最后一个非叶节点开始调整，使之满足最大堆
            adjustHeap(nums,i,len);
        }
        // exchange and adjust
        for(int j = len-1;j>=0;j--){
            //交换根节点与最后一个节点，通过不断把根节点（最大值）放到最后一个节点处，
            //实现数组从小到大排序
            swap(nums,0,j);
            //调整剩下的节点，使它们满足最大堆
            adjustHeap(nums,0,j);//j是当做长度传过去的，所以，去掉了最后一个节点
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
        //sortByList(head);
        //sortByList2(head);
        sort(arr);
    }
}
