package com.csms.leetcode.number.n1100.n1120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//最小的必要团队
//困难
public class Leetcode1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int len = req_skills.length;
        int length = (int)Math.pow(2,len);
        List<Integer>[] dp = new ArrayList[length];

        Map<String,Integer> map = new HashMap<>();
        //将技能对应二进制的位数
        for(int i=0 ; i<req_skills.length ; i++){
            map.put(req_skills[i],i);
        }
        dp[0] = new ArrayList<>();
        for(int i=0 ; i<people.size() ; i++){
            List<String> skills = people.get(i);
            List<Integer> list = new ArrayList<>();
            //当前人的技能的二进制位
            for(int j=0 ; j<skills.size() ; j++){
                list.add(map.get(skills.get(j)));
            }
            for(int j=length-1 ; j>=0 ; j--){
                if(dp[j]!=null){//说明这个状态是可达的
                    int num = j;
                    //状态叠加，加入当前人的技能
                    for(int k=0 ; k<list.size() ; k++){
                        num |= 1<<list.get(k);
                    }
                    if(dp[num]==null || dp[num].size()>dp[j].size()+1){
                        dp[num] = new ArrayList<>(dp[j]);
                        dp[num].add(i);
                    }
                }
            }
        }
        List<Integer> last = dp[length-1];
        int[] res = new int[last.size()];
        for(int i=0 ; i<last.size() ; i++){
            res[i] = last.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
    }
}