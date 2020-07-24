package com.csms.leetcode.number.other.other;

import java.util.LinkedList;
import java.util.List;

//动物收容所
//简单
public class LeetcodeMST_03_06 {
//animal[1]代表动物种类，其中 0 代表猫，1 代表狗。

    private List<int[]> zoo;

    public LeetcodeMST_03_06() {
        this.zoo = new LinkedList<int[]>();
    }

    public void enqueue(int[] animal) {
        this.zoo.add(animal);
    }

   public int[] dequeueAny() {
        if(this.zoo.size() <= 0) {
            return new int[]{-1,-1};
        }
        int[] res = this.zoo.get(0);
        this.zoo.remove(0);
        return res;
    }

    public int[] dequeueDog() {
        if(this.zoo.size() <= 0) {
            return new int[]{-1,-1};
        }
        for (int i = 0; i < this.zoo.size(); i ++) {
            if(this.zoo.get(i)[1] == 1) {
                int[] res= this.zoo.get(i);
                this.zoo.remove(i);
                return res;

            }
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        if(this.zoo.size() <= 0) {
            return new int[]{-1,-1};
        }
        for (int i = 0; i < this.zoo.size(); i ++) {
            if(this.zoo.get(i)[1] == 0) {
                int[] res= this.zoo.get(i);
                this.zoo.remove(i);
                return res;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
    }
}