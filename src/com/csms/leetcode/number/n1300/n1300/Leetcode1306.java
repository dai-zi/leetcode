package com.csms.leetcode.number.n1300.n1300;
//跳跃游戏III
//中等
public class Leetcode1306 {
public boolean canReach(int[] arr, int start) {
    boolean[] visited = new boolean[arr.length];
    return dfs(arr, start, visited);
  }

  private boolean dfs(int[] arr, int start, boolean[] visited) {
    if (arr[start] == 0)
      return true;
    visited[start] = true;
    int left = start - arr[start];
    if (left >= 0 && !visited[left] && dfs(arr, left, visited)) {
      return true;
    }
    int right = start + arr[start];
    return right < arr.length && !visited[right] && dfs(arr, right, visited);
  }

    public static void main(String[] args) {
    }
}