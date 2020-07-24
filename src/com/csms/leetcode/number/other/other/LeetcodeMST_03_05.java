package com.csms.leetcode.number.other.other;

import java.util.Deque;
import java.util.LinkedList;

//栈排序
//中等
public class LeetcodeMST_03_05 {
//原始栈
    Deque<Integer> stack = new LinkedList<>();
    //辅助栈
    Deque<Integer> tmp = new LinkedList<>();
    public LeetcodeMST_03_05() {

    }
    
    public void push(int val) {
        int max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
        int min = tmp.isEmpty() ? Integer.MIN_VALUE : tmp.peek();
        //比较原始栈与辅助栈栈顶值，使其满足 辅助栈 <= val <= 原始栈
        while(true){
            if(val > max){
                tmp.push(stack.pop());
                max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            }
            else if(val < min){
                stack.push(tmp.pop());
                min = tmp.isEmpty() ? Integer.MIN_VALUE : tmp.peek();
            }
            else{
                stack.push(val);
                break;
            }
        }
    }
    
    public void pop() {
        //将辅助栈元素push回原始栈
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
        if (!stack.isEmpty())
        System.out.println(stack.pop());

    }
    
    public int peek() {
        //将辅助栈元素push回原始栈
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty() && tmp.isEmpty();
    }

    public static void main(String[] args) {
        LeetcodeMST_03_05 test = new LeetcodeMST_03_05();
        test.push(3);
        test.push(5);
        test.push(4);
        test.push(2);
        test.push(1);
        test.push(98);
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        System.out.println();
    }
}