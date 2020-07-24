package com.csms.leetcode.number.other.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//最小跳跃次数
//困难
public class LeetcodeLCP09 {
    public int minJump(int[] jump) {
        LinkedList<Integer> list = new LinkedList();
        list.addLast(jump[0]);
        list.addLast(-1);
        //bfs 模拟下一步和往左走  当放入-1表示这次模拟已经结束
        //通过set来和max保证不重复放入, 同一个index重复放入肯定比之前的要步数多
        Set<Integer> set = new HashSet();
        set.add(jump[0]);
        int count = 1;
        int max = 0;
        while(list.size()>0){
            int index = list.pollFirst();
            if(index>jump.length-1){
                return count;
            } else if(index==-1){
                count++;
                list.addLast(-1);
            } else {
                //跳到下一步
                int temp = index+jump[index];
                //处理已经进入过就不用进入了
                if(!set.contains(temp)){
                    set.add(temp);
                    list.addLast(temp);
                }
                //当前0-index-1 可以进去
                //max 是之前已经走过的 在上一步已经放入过所以就不用在判断了
                for(int i=index-1;i>max;i--){
                    if(!set.contains(i)){
                        set.add(i);
                        list.addLast(i);
                    }
                }
                //更新max;
                max=Math.max(index, max);
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }
}