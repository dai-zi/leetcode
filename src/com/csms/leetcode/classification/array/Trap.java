package com.csms.leetcode.classification.array;

public class Trap {
    public int trap(int[] height) {
        if(height == null || height.length == 0 || height.length == 1){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            if(leftHeight < rightHeight){
                while(left < right){
                    left++;
                    if(height[left] <= leftHeight) {
                        res += leftHeight - height[left];
                    }else{
                        break;
                    }
                }
                leftHeight = height[left];
            }else{
                while(left < right){
                    right--;
                    if(height[right] <= rightHeight) {
                        res += rightHeight - height[right];
                    }else{
                        break;
                    }
                }
                rightHeight = height[right];
            }
        }
        return res;
    }
}
