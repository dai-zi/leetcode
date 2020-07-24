package com.csms.leetcode.number.other.other;
//搜索旋转数组
//中等
public class LeetcodeMST_10_03 {
public int search(int[] arr, int target) {

    return binarySearch(arr, target, 0, arr.length-1);
    }
    private int binarySearch(int[] arr, int target, int l, int r){
        if(l > r)
            return -1;
        if(l == r){
            if(target == arr[l])
                return l;
            else
                return -1;
        }
        int mid = l + (r - l) / 2;
        //如果左区间为升序的话
        if(arr[l] < arr[mid]){
            //target在左区间范围
            if(target <= arr[mid] && target >= arr[l])
                return binarySearch(arr, target, l, mid);
            else
                return binarySearch(arr, target, mid+1, r);
        }else if(arr[l] > arr[mid]){ //左区间不为升序
            //还是以左区间搜索为优先, 如果条件成立，target还是在左区间中
            if(target <= arr[mid] || target >= arr[l])
                return binarySearch(arr, target, l, mid);
            else
                return binarySearch(arr, target, mid+1, r);
        }else{
            int res = binarySearch(arr, target, l, mid);
            if(res != -1)
                return res;
            else
                return binarySearch(arr, target, mid+1, r);
        }
    }
    public static void main(String[] args) {
    }
}