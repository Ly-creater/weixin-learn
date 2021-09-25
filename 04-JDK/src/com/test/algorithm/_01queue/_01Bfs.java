package com.test.algorithm._01queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.algorithm
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class _01Bfs {

    public static void main(String[] args) {
        char[][] data={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
         int i = new Solution().numIslands(data);
        System.out.println(i);


    }

    static class Solution {

        public int numIslands(char[][] grid) {
            int count=0;
            int length=grid[0].length;
            int width=grid.length;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    if (grid[i][j]=='1'){
                        grid[i][j]='0';
                        //广度优先算法将相邻的设置为0
                        newBfs(i,j,width,length,grid);
                        count++;
                    }
                }
            }
           return count;
        }

        /**
         * 深度优先算法
         * @param i
         * @param j
         * @param width
         * @param length
         * @param grid
         */
        private void newBfs(int i, int j, int width, int length,char[][] grid) {
            if (i < 0 || i >= width || j < 0 || j >= length) return;
            if (  grid[i][j]=='0') return;
            newBfs(i-1,j,width,length,grid);
            newBfs(i,j-1,width,length,grid);
            newBfs(i+1,j,width,length,grid);
            newBfs(i,j+1,width,length,grid);
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

        public int[] findRoot(char[][] grid){
            int length = grid[0].length;
            int wigth = grid.length;
            for(int i=0;i<length;i++){
                for(int j=0;j<wigth;j++){
                    if(grid[j][i]=='1'){
                        return new int[]{j,i};
                    }
                }
            }
            return new int[]{-1,-1};
        }

        public int bfs(int[] first,char[][] grid){
            if (first[0]<0 || first[1]<0){
                return 0;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(first);
            while (!queue.isEmpty()){
                first=queue.peek();
                List<int[]> child = findChild(first, grid);
                queue.addAll(child);
                queue.poll();
            }
            return 1;
        }

        public List<int[]> findChild(int[] first,char[][] grid){
            if (first[0]<0 || first[1]<0){
                return null;
            }
            int length = first[1];
            int wigth = first[0];
            grid[wigth][length]='0';
            List<int[]> list = new ArrayList<>();
            //up
            if (wigth>0&&grid[wigth-1][length]=='1'){
                list.add(new int[]{wigth-1,length});
                grid[wigth-1][length]='0';
            }
            //left
            if (length>0&&grid[wigth][length-1]=='1'){
                list.add(new int[]{wigth,length-1});
                grid[wigth][length-1]='0';
            }
            //down
            if (wigth+1<grid.length && grid[wigth+1][length] == '1'){
                list.add(new int[]{wigth+1,length});
                grid[wigth+1][length]='0';
            }
            //right
            if (length+1<grid[0].length && grid[wigth][length+1] == '1'){
                list.add(new int[]{wigth,length+1});
                grid[wigth][length+1]='0';
            }
            return list;
        }


    }
}
