package com.test.algorithm._01queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    //dfs_lands(i, j, grid, m, n);
                    bfs_lands(i, j, grid, m, n);
                }
            }
        }

        return count;
    }

    /**
     * 利用深度优先遍历来对 (i,j) 相邻的1进行标记
     */
    private void dfs_lands(int i, int j, char[][] grid, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0'; // 标记为 0
        dfs_lands(i-1, j, grid, m, n);
        dfs_lands(i, j-1, grid, m, n);
        dfs_lands(i+1, j, grid, m, n);
        dfs_lands(i, j+1, grid, m, n);
    }

    /**
     * 用广度优先遍历算法来标记(i,j) 周围的1
     */
    private void bfs_lands(int i, int j, char[][] grid, int m, int n) {
        Queue<GridNode> queue = new LinkedBlockingQueue<>();
        queue.offer(new GridNode(i, j));
        while (!queue.isEmpty()) {
            int thisLevelSize = queue.size();
            for (int k = 0; k < thisLevelSize; k++) {
                GridNode cur = queue.poll();
                if (cur.i < 0 || cur.i >= m || cur.j < 0 || cur.j >= n) {
                    continue;
                }
                if (grid[cur.i][cur.j] == '1') {
                    grid[cur.i][cur.j] = '0';
                    queue.offer(new GridNode(cur.i-1, cur.j));
                    queue.offer(new GridNode(cur.i+1, cur.j));
                    queue.offer(new GridNode(cur.i, cur.j-1));
                    queue.offer(new GridNode(cur.i, cur.j+1));
                }
            }
        }
    }

    class GridNode {
        int i, j;

        public GridNode(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}