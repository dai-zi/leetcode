package com.csms.leetcode.number.n300.n360;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//水壶问题
//中等
public class Leetcode365 {
    int capacityX,capacityY;
    int[][] state;
    boolean flag = false;
    public boolean Leetcode365(int x, int y, int z) {
        capacityX = x;
        capacityY = y;
        state = new int[x+1][y+1];
        dp(0,0,z);
        return flag;
    }
    public void dp(int x,int y,int z){
        if(flag){return;}
        if(x==z||y==z||x+y==z){
            flag = true;
            return;
        }
        if(state[x][y]==1){
            return;
        }else{
            state[x][y]=1;
        }
        dp(0,y,z);
        dp(x,0,z);
        dp(capacityX,y,z);
        dp(x,capacityY,z);
        dp(Math.min(x+y,capacityX),Math.max(y-capacityX+x,0),z);
        dp(Math.max(x-capacityY+y,0),Math.min(x+y,capacityY),z);
    }
    //
    //int capacityX;
    //int capacityY;
    public boolean canMeasureWater(int x, int y, int z) {
        capacityX = x;
        capacityY = y;
        Set<Long> set = new HashSet<>();
        Queue<Long> dfs = new LinkedList<>();   //遍历链表
        dfs.add(0L);
        while(!dfs.isEmpty()){
            Long l = dfs.poll();
            if(set.contains(l)){
                continue;
            }
            x = (int)(l>>32);
            y = (int)l.intValue();
            if(x==z||y==z||x+y==z){
                return true;
            }
            set.add(l);
            if(x!=0&&y!=0){
                dfs.add((long)y);
                dfs.add(((long)x)<<32);
            }
            if(x!=capacityX){
                dfs.add(combineToLong(capacityX,y));
                if(y!=0){
                    dfs.add(combineToLong(Math.min(x+y,capacityX),Math.max(y-capacityX+x,0)));
                }
            }
            if(y!=capacityY){
                dfs.add(combineToLong(x,capacityY));
                if(x!=0){
                    dfs.add(combineToLong(Math.max(x-capacityY+y,0),Math.min(x+y,capacityY)));
                }
            }
        }
        return false;
    }
    public long combineToLong(int a,int b){
        long res = (long)a;
        res = res<<32;
        return res|b;
    }
    //math
    public boolean canMeasureWater1(int x, int y, int z) {
        if(x==z||y==z||x+y<=z){
            if(x+y<z){
                return false;
            }
            return true;
        }
        return x>y?(z%gcd(x,y))==0:(z%gcd(y,x))==0;
    }
    public int gcd(int x,int y){
        return y==0?x:gcd(y,x%y);
    }

    public static void main(String[] args) {
    }
}