package com.csms.leetcode.classification.search;

public class SearchRotateArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        //������������
        int index = -1;
        boolean isTotalNumsHasBeenSorted = false;
        if(nums[nums.length - 1] >= nums[0]){
            isTotalNumsHasBeenSorted = true;
            index = 0;
        }

        //Ѱ����������С��Ԫ��
        if(!isTotalNumsHasBeenSorted){
            int l = 0;
            int r = nums.length - 1;
            int m = (l+r)/2;
            while(l <= r) {
                if (nums[m] == target) {
                    return m;
                }
                if (nums[m] >= nums[0]) {
                    l = m + 1;
                    m = (l + r) / 2;
                }else if(nums[m] < nums[0]){
                    if(nums[m] >= nums[m-1]){
                        r = m - 1;
                        m = (l+r) / 2;
                    }else{
                        index = m;
                        break;
                    }
                }
            }
        }

        int l = 0;
        int r = 0;
        int m = 0;
        if(isTotalNumsHasBeenSorted){
            //����������������������ֲ���
            l = 0;
            r = nums.length - 1;
            m = (l+r) / 2;
        }else{
            if(nums[index] <= target && target <= nums[nums.length - 1]){
                //{4,5,6,7,0,1,2},target=1������{0,1,2}����
                l = index;
                r = nums.length - 1;
                m = (l+r) / 2;
            }else{//{4,5,6,7,0,1,2},target=5������{4,5,6,7}����
                l = 0;
                r = index - 1;
                m = (l+r) / 2;
            }
        }
        //���ֲ���
        while(l <= r) {
            if (nums[m] == target) {
                return m;
            }else if (nums[m] < target) {
                l = m + 1;
                m = (l + r) / 2;
            }else if(nums[m] > target){
                r = m - 1;
                m = (l+r) / 2;
            }
        }
        return -1;
    }
}
