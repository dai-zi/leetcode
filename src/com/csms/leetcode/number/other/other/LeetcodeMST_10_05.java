package com.csms.leetcode.number.other.other;
//稀疏数组搜索
//简单
public class LeetcodeMST_10_05 {
public int findString(String[] words, String S) {
    if (words == null || words.length == 0) return -1;
    int left = 0, right = words.length-1;
    while (left <= right){
        while (left <= right && words[left].length() == 0)left++;
        while (left <= right && words[right].length() == 0)right--;
        int mid = left + (right-left)/2;
        while (mid < right && words[mid].length() == 0) mid++;
        if (words[mid].equals(S)) return mid;
        else if (words[mid].compareTo(S) > 0) right = mid-1;
        else left = mid+1;
    }
    return -1;
}
    public static void main(String[] args) {
    }
}