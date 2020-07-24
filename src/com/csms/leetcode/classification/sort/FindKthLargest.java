package com.csms.leetcode.classification.sort;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        HeapSort1.create_heap(nums);
        int KthLargest = -1;
        int i = 0;
        while(i < k){
            KthLargest = nums[0];
            nums[0] = nums[nums.length - i -1];
            HeapSort1.fix_down(nums, 0, nums.length - i - 2);
            i++;
        }
        return KthLargest;
    }


}
class HeapSort1 {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void create_heap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fix_down(arr, i, arr.length - 1);
        }
    }

    public static void fix_down(int[] arr, int i, int end) {
        int child = (i << 1) + 1; // ��ǰ�ڵ������
        int temp = arr[i];

        while (child <= end) {
            // ѡ���������ӽϴ���Ǹ�
            if (child < end && arr[child + 1] > arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                arr[i] = arr[child]; // ���ӽڵ��뵱ǰ�ڵ��滻
                i = child;
                child = (i << 1) + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }


    public static void head_sort(int[] arr) {
        // ȡ���Ѷ�Ԫ�أ������һ��Ԫ�ؽ�����������
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i]; // ���һ��Ԫ��
            arr[i] = arr[0];
            arr[0] = temp;
            fix_down(arr, 0, i - 1);

        }
    }
}