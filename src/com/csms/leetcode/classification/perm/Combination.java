package com.csms.leetcode.classification.perm;

import java.util.*;

public class Combination {


    public static void combHelp(List<Integer> dst, List<Integer> nums, int k){
        if(k == 0){
            for(Integer integer : dst){
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            dst.add(nums.get(i));
            combHelp(dst, getList(nums, i),k-1);
            dst.remove(dst.size() -1 );
        }
    }
    public static List<Integer> getList(List<Integer> nums, int k){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++){
            if(i != k){
                res.add(nums.get(i));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            nums.add(i);
        }
        //combHelp(new ArrayList<>(), nums, 9000);

//        int[] nums = new int[10000];
//        for(int i = 0; i < 10000; i++){
//            nums[i] = i;
//        }
        comb(nums, 3);
    }

    public static void comb(List<Integer> nums, int k){
        if(null == nums || nums.size() == 0 || k > nums.size() || k <= 0){
            return;
        }
        Queue<Comb> q = new LinkedList<>();
        Comb comb = new Comb();
        comb.k = k;
        comb.src = nums;
        comb.dst = new ArrayList<>();
        q.add(comb);
        while(!q.isEmpty()){
            Comb tmp = q.remove();
            if(tmp.k == 0){
                tmp.output();
                continue;
            }
            for(int i = 0; i < tmp.src.size(); i++){
                List<Integer> tmpSrc = new ArrayList<>(tmp.src);
                List<Integer> tmpDst = new ArrayList<>(tmp.dst);
                Comb nextLevel = new Comb();
                nextLevel.k = tmp.k - 1;
                tmpDst.add(tmpSrc.get(i));
                tmpSrc.remove(i);
                nextLevel.src = tmpSrc;
                nextLevel.dst = tmpDst;
                q.add(nextLevel);
            }
        }
    }
}
class Comb{
    int k;
    List<Integer> src;
    List<Integer> dst;

    public void output(){
        for(Integer integer : dst){
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}