package com.csms.leetcode.number.n1000.n1060;
//负二进制数相加
//中等
public class Leetcode1073 {
public int[] addNegabinary(int[] arr1, int[] arr2) {
        if(arr1[0]==0) return arr2;
        if(arr2[0]==0) return arr1;
        int len1=arr1.length;
        int len2=arr2.length;
        int len=Math.max(len1,len2)+2;
        int[] ans=new int[len];
        int cur=len;
        int temp=len-1;
        while(len1>=1||len2>=1||cur>=1){
            if(len1>=1){
                ans[cur-1]+=arr1[len1-1];
                len1--;
            }
            if(len2>=1){
                ans[cur-1]+=arr2[len2-1];
                len2--;
            } 
            while(ans[cur-1]<0){
                ans[cur-1]=ans[cur-1]+2;
                ans[cur-2]++;
            }
            while(ans[cur-1]>1){
                ans[cur-1]-=2;
                ans[cur-2]--;
            }
            cur--;
        }
        for(int i=0;i<len;i++){
            if(ans[i]==1){
                temp=i;
                break;
            }
        }
        int[] res=new int[len-temp];
        for(int i=0,j=temp;j<len;j++,i++){
            res[i]=ans[j];
        }
        return res;
    }

    public static void main(String[] args) {
    }
}