package com.csms.leetcode.number.n900.n900;

import java.util.Stack;

//股票价格跨度
//中等
public class Leetcode901 {
Stack<Integer> prices, weights;

    public Leetcode901() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
    }
}