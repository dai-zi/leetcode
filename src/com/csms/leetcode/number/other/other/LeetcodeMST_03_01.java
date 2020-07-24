package com.csms.leetcode.number.other.other;
//三合一
//简单
public class LeetcodeMST_03_01 {
private int[] arr;

    private int[] top;

    private int stackSize;

    public LeetcodeMST_03_01(int stackSize) {
        if(stackSize < 1) {
            stackSize = 0;
        }
        this.stackSize = stackSize;
        this.arr = new int[stackSize * 3];
        this.top = new int[3];
        for (int i = 0; i < this.top.length; i ++) {
            top[i] = stackSize * i;
        }
    }

    public void push(int stackNum, int value) {
        //判断是否超出限制
        if(top[stackNum] >= (stackNum + 1) * stackSize) {
            return;
        }
        arr[top[stackNum] ++ ] = value;
    }

    public int pop(int stackNum) {
        //判断是否为空，为空返回-1
        if(top[stackNum] <= stackNum * stackSize) {
            return -1;
        }
        return arr[-- top[stackNum]];
    }

    public int peek(int stackNum) {
        if(top[stackNum] <= stackNum * stackSize) {
            return -1;
        }
        return arr[top[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        if(top[stackNum] <= stackNum * stackSize) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}