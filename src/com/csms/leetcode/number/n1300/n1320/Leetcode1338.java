package com.csms.leetcode.number.n1300.n1320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//数组大小减半
//中等
public class Leetcode1338 {
public int minSetSize(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> cnt=new ArrayList<>();
        cnt.add(1);
        for (int i=1;i<arr.length;i++){
            if (arr[i]==arr[i-1])
                cnt.set(cnt.size()-1,cnt.get(cnt.size()-1)+1);
            else{
                cnt.add(1);
            }
        }
        Collections.sort(cnt);
        int num=0;
        for (int i=cnt.size()-1;i>=0;i--){
            num+=cnt.get(i);
            if (num*2>=arr.length)
                return cnt.size()-i;
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}