package com.csms.leetcode.number.other.other;

import java.util.*;

//幂集
//中等
public class LeetcodeMST_08_04 {
Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,0,new ArrayList<Integer>());
        res.addAll(set);
        return res;
    }
    public void backtrack(int[] nums,int first,List<Integer> pre){
        set.add(new ArrayList<>(pre));
        for(int i=first;i<nums.length;i++){
            pre.add(nums[i]);
            backtrack(nums,i+1,pre);
            pre.remove(pre.size()-1);
        }
    }

    public static void main(String[] args) {
    }
}