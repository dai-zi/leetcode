package com.csms.leetcode.number.n700.n760;
//情侣牵手
//困难
public class Leetcode765 {
    int N;
    int[][] pairs;

    public int minSwapsCouples(int[] row) {
        N = row.length / 2;
        pairs = new int[N][2];
        for (int i = 0; i < N; ++i) {
            pairs[i][0] = row[2*i] / 2;
            pairs[i][1] = row[2*i+1] / 2;
        }

        return solve(0);
    }

    public void swap(int a, int b, int c, int d) {
        int t = pairs[a][b];
        pairs[a][b] = pairs[c][d];
        pairs[c][d] = t;
    }

    public int solve(int i) {
        if (i == N) return 0;
        int x = pairs[i][0], y = pairs[i][1];
        if (x == y) return solve(i+1);

        int jx=0, kx=0, jy=0, ky=0; // Always gets set later
        for (int j = i+1; j < N; ++j) {
            for (int k = 0; k <= 1; ++k) {
                if (pairs[j][k] == x) {jx = j; kx = k;}
                if (pairs[j][k] == y) {jy = j; ky = k;}
            }
        }

        swap(i, 1, jx, kx);
        int ans1 = 1 + solve(i+1);
        swap(i, 1, jx, kx);

        swap(i, 0, jy, ky);
        int ans2 = 1 + solve(i+1);
        swap(i, 0, jy, ky);

        return Math.min(ans1, ans2);
    }
    public static void main(String[] args) {
    }

    //

    public int minSwapsCouples1(int[] row) {
        int N = row.length / 2;
        //couples[x] = {i, j} means that
        //couple #x is at couches i and j (1 indexed)
        int[][] couples = new int[N][2];

        for (int i = 0; i < row.length; ++i)
            add(couples[row[i]/2], i/2 + 1);

        //adj[x] = {i, j} means that
        //x-th couch connected to couches i, j (all 1 indexed) by couples
        int[][] adj = new int[N+1][2];
        for (int[] couple: couples) {
            add(adj[couple[0]], couple[1]);
            add(adj[couple[1]], couple[0]);
        }

        // The answer will be N minus the number of cycles in adj.
        int ans = N;
        // For each couch (1 indexed)
        for (int r = 1; r <= N; ++r) {
            // If this couch has no people needing to be paired, continue
            if (adj[r][0] == 0 && adj[r][1] == 0)
                continue;

            // Otherwise, there is a cycle starting at couch r.
            // We will use two pointers x, y with y faster than x by one turn.
            ans--;
            int x = r, y = pop(adj[r]);
            // When y reaches the start 'r', we've reached the end of the cycle.
            while (y != r) {
                // We are at some couch with edges going to 'x' and 'new'.
                // We remove the previous edge, since we came from x.
                rem(adj[y], x);

                // We update x, y appropriately: y becomes new and x becomes y.
                x = y;
                y = pop(adj[y]);
            }
        }
        return ans;
    }

    // Replace the next zero element with x.
    public void add(int[] pair, int x) {
        pair[pair[0] == 0 ? 0 : 1] = x;
    }

    // Remove x from pair, replacing it with zero.
    public void rem(int[] pair, int x) {
        pair[pair[0] == x ? 0 : 1] = 0;
    }

    // Remove the next non-zero element from pair, replacing it with zero.
    public int pop(int[] pair) {
        int x = pair[0];
        if (x != 0) {
            pair[0] = 0;
        } else {
            x = pair[1];
            pair[1] = 0;
        }
        return x;
    }
}