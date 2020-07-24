package com.csms.leetcode.number.n1300.n1340;

import java.util.ArrayList;
import java.util.List;

//最后K个数的乘积
//中等
public class Leetcode1352 {
private List<Integer> products;

  public Leetcode1352() {
    products = new ArrayList<>();
    products.add(1);
  }

  public void add(int num) {
    if(num == 0){
      products = new ArrayList<>();
      products.add(1);
    } else {
      products.add(products.get(products.size() - 1) * num);
    }
  }

  public int getProduct(int k) {
    if(products.size() <= k ){
      return 0;
    }
    return products.get(products.size() - 1) / products.get(products.size() - 1- k);
  }
    public static void main(String[] args) {
    }
}