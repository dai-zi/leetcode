package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.Arrays;

//水域大小
//中等
public class LeetcodeMST_16_19 {
public int[] pondSizes(int[][] land) {
        ArrayList<Integer> resList=new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==0){
                    int count=get(land,i,j);
                    resList.add(count);
                }
            }
        }
        int[] res=new int[resList.size()];
        for(int i=0;i<resList.size();i++){
            res[i]=resList.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int get(int[][] land, int i,int j){
        if(i<0 || i>=land.length || j<0 || j>=land[0].length || land[i][j]!=0){
            return 0;
        }
        land[i][j]=-1;
        int count=1;
        count+=get(land, i+1, j);
        count+=get(land, i-1, j);
        count+=get(land, i, j+1);
        count+=get(land, i, j-1);
        count+=get(land, i+1, j+1);
        count+=get(land, i-1, j+1);
        count+=get(land, i-1, j-1);
        count+=get(land, i+1, j-1);
        return count;

    }

    public static void main(String[] args) {
    }
}