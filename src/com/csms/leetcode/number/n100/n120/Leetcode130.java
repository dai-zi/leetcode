package com.csms.leetcode.number.n100.n120;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//被围绕的区域
//中等
public class Leetcode130 {
    //dfs递归
    public void solve3(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs1(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs1(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }
        board[i][j] = '#';
        dfs1(board, i - 1, j); // 上
        dfs1(board, i + 1, j); // 下
        dfs1(board, i, j - 1); // 左
        dfs1(board, i, j + 1); // 右
    }

    //dfs非递归
    public class Pos{
        int i;
        int j;
        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void solve2(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘第一个是o的开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(i, j));
        board[i][j] = '#';
        while (!stack.isEmpty()) {
            // 取出当前stack 顶, 不弹出.
            Pos current = stack.peek();
            // 上
            if (current.i - 1 >= 0
                    && board[current.i - 1][current.j] == 'O') {
                stack.push(new Pos(current.i - 1, current.j));
                board[current.i - 1][current.j] = '#';
                continue;
            }
            // 下
            if (current.i + 1 <= board.length - 1
                    && board[current.i + 1][current.j] == 'O') {
                stack.push(new Pos(current.i + 1, current.j));
                board[current.i + 1][current.j] = '#';
                continue;
            }
            // 左
            if (current.j - 1 >= 0
                    && board[current.i][current.j - 1] == 'O') {
                stack.push(new Pos(current.i, current.j - 1));
                board[current.i][current.j - 1] = '#';
                continue;
            }
            // 右
            if (current.j + 1 <= board[0].length - 1
                    && board[current.i][current.j + 1] == 'O') {
                stack.push(new Pos(current.i, current.j + 1));
                board[current.i][current.j + 1] = '#';
                continue;
            }
            // 如果上下左右都搜索不到,本次搜索结束，弹出stack
            stack.pop();
        }
    }
    //bfs非递归
    public void solve1(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘第一个是o的开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        board[i][j] = '#';
        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            // 上
            if (current.i - 1 >= 0
                    && board[current.i - 1][current.j] == 'O') {
                queue.add(new Pos(current.i - 1, current.j));
                board[current.i - 1][current.j] = '#';
                // 没有continue.
            }
            // 下
            if (current.i + 1 <= board.length - 1
                    && board[current.i + 1][current.j] == 'O') {
                queue.add(new Pos(current.i + 1, current.j));
                board[current.i + 1][current.j] = '#';
            }
            // 左
            if (current.j - 1 >= 0
                    && board[current.i][current.j - 1] == 'O') {
                queue.add(new Pos(current.i, current.j - 1));
                board[current.i][current.j - 1] = '#';
            }
            // 右
            if (current.j + 1 <= board[0].length - 1
                    && board[current.i][current.j + 1] == 'O') {
                queue.add(new Pos(current.i, current.j + 1));
                board[current.i][current.j + 1] = '#';
            }
        }
    }
    //bfs递归 --no

    //并查集

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 遇到O进行并查集操作合并
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        // 边界上的O,把它和dummyNode 合并成一个连通区域.
                        uf.union(node(i, j), dummyNode);
                    } else {
                        // 和上下左右合并成一个连通区域.
                        if (i > 0 && board[i - 1][j] == 'O')
                            uf.union(node(i, j), node(i - 1, j));
                        if (i < rows - 1 && board[i + 1][j] == 'O')
                            uf.union(node(i, j), node(i + 1, j));
                        if (j > 0 && board[i][j - 1] == 'O')
                            uf.union(node(i, j), node(i, j - 1));
                        if (j < cols - 1 && board[i][j + 1] == 'O')
                            uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(node(i, j), dummyNode)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int node(int i, int j) {
        return 0;
        //return i * cols + j; ???
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }
        // 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        int find(int node) {
            while (parents[node] != node) {
                // 当前节点的父节点 指向父节点的父节点.
                // 保证一个连通区域最终的parents只有一个.
                parents[node] = parents[parents[node]];
                node = parents[node];
            }

            return node;
        }

        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
    public static void main(String[] args) {
    }
}