package com.csms.leetcode.number.n1400.n1460;

import java.util.*;

//课程安排IV
//中等
public class Leetcode1462 {
	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        //构建一个可达的map表，留着一会bfs用
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] val : prerequisites) {
            HashSet<Integer> set = map.containsKey(val[0]) ? map.get(val[0]) : new HashSet<>();
            set.add(val[1]);
            map.put(val[0], set);
        }

        //创建一个结果集，里面存放所有可达关系
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            bfser(map, i, n, res);
        }

        //统计答案
        List<Boolean> ans = new ArrayList<>();
        for (int[] val : queries) {
            ans.add(res.contains(val[0] + "_" + val[1]));
        }
        return ans;
    }

    private void bfser(HashMap<Integer, HashSet<Integer>> map, int i, int n, HashSet<String> res) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        //如果这个值在map中不存在，说明他到其他课程没有可达关系
        if (!map.containsKey(i)) return;
        queue.offerLast(i);
        //我们的目标就是求root到其他点的可达关系，所以在bfs过程中，记录下这个可达关系，放在set里，这里
        //我用 a_b 这种字符串形式来记录了。
        visited[i] = true;
        while (!queue.isEmpty()) {
            HashSet<Integer> data = map.get(queue.pollFirst());
            if (data != null) {
                for (Integer d : data) {
                    if (!visited[d]) {
                        res.add(i + "_" + d);
                        queue.offerLast(d);
                        visited[d] = true;
                    }
                }
            }
        }
        //遍历结束后，所有可达的线都可以记录下来，求完所有的课程即可形成一个最终的统计集合，就可以遍历一遍查询数据
        //来返回结果了。
    }
    public static void main(String[] args) {
    }
}