package com.csms.leetcode.number.other.other;

import java.util.Arrays;

//最小差
//中等
public class LeetcodeMST_16_06 {
public int smallestDifference(int[] a, int[] b) {
    	long min =  Integer.MAX_VALUE;
    	int aP = 0;
    	int bP = 0;
    	Arrays.parallelSort(a);
    	Arrays.parallelSort(b);
    	while(aP<a.length && bP<b.length) {
    		if(min == 0)return 0;
    		if(a[aP]<b[bP]) {
    			while(aP<a.length &&a[aP]<b[bP]) {
        			aP++;
        		}
    			if(aP<a.length) {
    				min = Math.min(min, Math.abs((long)a[aP]-b[bP]));
            		
    			}
                min = Math.min(min, Math.abs((long)a[aP-1]-b[bP]));
        		
    		}else if(a[aP]>=b[bP]) {
    			while(bP<b.length &&a[aP]>b[bP]) {
        			bP++;
        		}
    			if(bP<b.length) {
    				min = Math.min(min, Math.abs((long)a[aP]-b[bP]));
    				
    			}
                min = Math.min(min, Math.abs((long)a[aP]-b[bP-1]));
    		}
    		
    		
    	}
    	return (int)min;
    }

    public static void main(String[] args) {
    }
}