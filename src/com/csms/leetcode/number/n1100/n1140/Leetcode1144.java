package com.csms.leetcode.number.n1100.n1140;
//递减元素使数组呈锯齿状
//中等
public class Leetcode1144 {
public int movesToMakeZigzag(int[] nums) {
        // 偶大相邻
        int opt = evenNums(copyNums(nums));
        // 为0，就表示已经是锯齿数组
        if(opt == 0){
            return 0;
        }

        int oddOpt = oddNums(nums);
        opt = opt < oddOpt ? opt : oddOpt;
        return opt;
    }

    /**
     * 赋值数组
     * @param nums
     * @return
     */
    private int[] copyNums(int[] nums){
        int len = nums.length;
        int[] nums1 = new int[len];
        for(int i = 0; i < len; i++){
            nums1[i] = nums[i];
        }
        return nums1;
    }
    /**
    * 奇数索引大于相邻
    */
    private int oddNums(int[] nums){
        return getOpts(nums, 1, 0);
    }
    /**
    * 偶数索引大于相邻
    */
    private int evenNums(int[] nums){
        return getOpts(nums, 0, 0);
    }
    
    /**
    * 跟相邻的元素比较
    */
    private int getOpts(int[] nums, int startIndex, int tmpOpt){
        int len = nums.length;
        for(int i = startIndex; i < len; i+=2){
            if(i-1 >= 0 && nums[i] <= nums[i-1]){
                int curtOpt = nums[i-1] - nums[i] + 1;
                tmpOpt += curtOpt;
                nums[i-1] -= curtOpt;
            }
            if(i+1 < len && nums[i] <= nums[i+1]){
                int curtOpt = nums[i+1] - nums[i] + 1;
                tmpOpt += curtOpt;
                nums[i+1] -= curtOpt;
            }
           
        }
        return tmpOpt;
    }

    public static void main(String[] args) {
    }
}