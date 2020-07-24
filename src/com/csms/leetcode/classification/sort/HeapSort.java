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
     * ������
     * @param nums
     * @param i
     * @param len
     */
    public static void adjustHeap(int nums[],int i,int len){
        int temp = nums[i];//��¼��ǰ�ڵ�ֵ�����ڵ㣩
        //���±����ӽڵ�
        for(int k = 2*i+1;k<len;k = k*2+1){
            //����������ӽڵ㣬�����ӽڵ�������ӽڵ�
            if(k+1<len&&nums[k]<nums[k+1]){
                k++;//ָ�����ӽڵ�
            }
            //����ӽڵ�ȵ�ǰ�ڵ㣨���ڵ㣩�����ӽڵ�ֵ�������ڵ�
            if(nums[k]>temp){
                nums[i] = nums[k];
                i = k;//��¼���ڵ��λ�ã�����Ҫ�䵽��λ��
            }else{//����ӽڵ�С�ڸ��ڵ㣬���������
                break;
            }
        }
        //����ǰ���ڵ��ֵ��������λ����
        nums[i] = temp;
    }
    /**
     * ��������������
     * ͨ�����ϰѸ��ڵ㣨���ֵ���ŵ����һ���ڵ㴦��
     * ʵ�������С��������
     * @param nums
     */
    public static void heapSort(int nums[]){
        int len = nums.length;
        // build heap
        for(int i = len/2-1;i>=0;i--){
            //�����һ����Ҷ�ڵ㿪ʼ������ʹ֮��������
            adjustHeap(nums,i,len);
        }
        // exchange and adjust
        for(int j = len-1;j>=0;j--){
            //�������ڵ������һ���ڵ㣬ͨ�����ϰѸ��ڵ㣨���ֵ���ŵ����һ���ڵ㴦��
            //ʵ�������С��������
            swap(nums,0,j);
            //����ʣ�µĽڵ㣬ʹ������������
            adjustHeap(nums,0,j);//j�ǵ������ȴ���ȥ�ģ����ԣ�ȥ�������һ���ڵ�
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
