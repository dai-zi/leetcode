package com.csms.leetcode.number.n300.n300;

import java.util.*;

//计算右侧小于当前元素的个数
//困难
public class Leetcode315 {

    public static void main(String[] args) {
    }
}
//暴力
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            for (int j = i+ 1; j<nums.length; j++){
                if (nums[j]<nums[i]){
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
}

//BST二叉树 可改进为自平衡的二叉树
class Solution2 {
    class Node{
        Node left;
        Node right;
        int val;
        int count;
        Node(int val){
            this.val = val;
            this.count = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length==0) return new LinkedList<Integer>();
        Node root = new Node(nums[nums.length-1]);
        List<Integer> list = new LinkedList<>();
        list.add(0);
        for (int j = nums.length-2; j>=0; j--){
            list.add(search(root, nums[j]));
            root = insert(root, nums[j]);
        }
        Collections.reverse(list);
        return list;
    }

    private Node insert(Node root, int val){
        if (root == null){
            return new Node(val);
        }
        if (root.val == val){
            root.count += 1;
        }else if (root.val > val){
            root.count += 1;
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int search(Node root, int val){
        if (root == null){
            return 0;
        }
        if (root.val < val){
            return root.count + search(root.right, val);
        }else{
            return search(root.left, val);
        }
    }
}

//BIT树状数组
class Solution3 {
    public List<Integer> countSmaller(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bits = new int[nums.length+1];
        List<Integer> list = new LinkedList<>();
        Arrays.sort(copy);
        for (int i = nums.length-1; i>=0; i--){
            int index = indexOf(copy, nums[i]);
            list.add(search(bits, index-1));
            insert(bits, index);
        }
        Collections.reverse(list);
        return list;
    }

    private void insert(int[] bits, int index){
        while (index<bits.length){
            bits[index] += 1;
            index += index&(-index);
        }
    }

    private int search(int[] bits, int index){
        int res = 0;
        while (index>0){
            res += bits[index];
            index -= index&(-index);
        }
        return res;
    }

    private int indexOf(int[] copy, int val){
        int lo = 0, hi = copy.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (copy[mid]<val){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo+1;
    }
}

//MergeSort变形
class Solution4 {
    Map<Integer, Integer> res;
    public List<Integer> countSmaller(int[] nums) {
        res = new HashMap<>();
        int[][] numsWithIndex = new int[nums.length][2];
        for (int i = 0; i<nums.length; i++){
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }
        List<Integer> ans = new LinkedList<>();
        mergeSort(numsWithIndex, 0, nums.length-1);
        for (int n = 0; n < nums.length; n++){
            ans.add(res.getOrDefault(n, 0));
        }
        return ans;
    }

    private void mergeSort(int[][] nums, int lo, int hi){
        if (lo>=hi){
            return;
        }
        int mid = lo + (hi-lo)/2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid+1, hi);
        int i = lo, j = mid+1, k = 0;
        int[][] cmp = new int[hi-lo+1][2];
        while (i<=mid){
            while (j<=hi&&nums[j][0]<nums[i][0]) {
                cmp[k++] = nums[j++];
            }
            res.put(nums[i][1], res.getOrDefault(nums[i][1], 0)+j-mid-1);
            cmp[k++] = nums[i++];
        }
        while (j<=hi) cmp[k++] = nums[j++];
        System.arraycopy(cmp, 0, nums, lo, cmp.length);
    }
}
