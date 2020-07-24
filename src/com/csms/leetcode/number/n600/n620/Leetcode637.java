package com.csms.leetcode.number.n600.n620;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉树的层平均值
//简单
public class Leetcode637 {
    public List < Double > averageOfLevels(TreeNode root) {
        List< Integer > count = new ArrayList< >();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    public void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
    public static void main(String[] args) {
    }
}