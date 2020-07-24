package com.csms.leetcode.number.n1300.n1340;

import java.util.HashMap;
import java.util.Map;

//每隔n个顾客打折
//中等
public class Leetcode1357 {
Map<Integer, Integer> pricesMap;
    int n, discount, count;

    public Leetcode1357(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.count = 0;
        this.pricesMap = new HashMap<>();
        for(int i = 0; i < products.length; i++) {
            pricesMap.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        double billAmount = 0;
        for(int i = 0; i < product.length; i++) {
            billAmount +=  amount[i] * pricesMap.get(product[i]);
        }
        count++;
        
        return (count % n != 0) ? billAmount : billAmount * (100 - discount) / 100.0;
    }

    public static void main(String[] args) {
    }
}