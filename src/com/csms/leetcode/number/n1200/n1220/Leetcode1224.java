package com.csms.leetcode.number.n1200.n1220;

import java.util.HashMap;
import java.util.Map;

//最大相等频率
//困难
public class Leetcode1224 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 1 , max = 0 , maxCount = 0 , oneCount = 0 , maxSubOneCount = 0;
        for(int i=0;i<nums.length;i++){
            // map存储 数字+出现次数
            Integer count = map.get(nums[i]);
            if(count==null){
                count = 0;
            }
            map.put(nums[i],++count);
            // 计算频次为1的个数
            if(count==1){
                oneCount++;
            }else if(count==2){
                oneCount--;
            }
            // 计算最大频次-1的个数
            if(max>=2){ // 最大频次大于等于二才需要计算
                if(count==max-1){
                    // 达到频次最大值-1 计入一个
                    maxSubOneCount++;
                }else if(count == max){
                    // 达到max,之前为max-1,max-1计数减少一个
                    maxSubOneCount--;
                }
            }
            // 计算最大频次
            if(count == max){
                maxCount++;
            }
            // 最大频次发生变化
            if(count>max){
                // 频次最大值变化
                max = count;
                // 前最大频次-1的个数=前最大频次个数>0?前最大频次个数-1:0
                maxSubOneCount = maxCount > 0 ? maxCount - 1 : 0;
                // 频次最大当前只有一个了
                maxCount = 1;
            }
            int size = map.size();
            // 1.一个最大频次其他全为最大频次减1；2.一个频次为1其他全为最大频次；3.频次全为1；
            if((maxCount+maxSubOneCount==size&&maxCount==1)
                    ||(maxCount+oneCount==size&&oneCount==1)
                    ||(oneCount==size)){
                res = i+1;
            }
        }
        return res;
    }
    public int maxEqualFreq1(int[] nums) {
        int n = nums.length;
        int[] count = new int[100001];
        int[] freq = new int[100001];

        for(int i = 0; i < n; i++){
            count[nums[i]]++;
            freq[count[nums[i]]]++;
        }

        for(int i = n - 1; i >= 0; i--){
            if(count[nums[i]] * freq[count[nums[i]]] == i){
                return i + 1;
            }
            freq[count[nums[i]]]--;
            count[nums[i]]--;
            if(count[nums[i-1]] * freq[count[nums[i-1]]] == i){
                return i + 1;
            }
        }return 1;
    }
    public static void main(String[] args) {
    }
}