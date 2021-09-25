package com.test.algorithm._01queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.algorithm._01queue
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class _03Squ {
   static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().numSquares(7168));
        }
       public int numSquares(int n) {
           HashSet<Integer> set = new HashSet<>();
           int count=0;
           Queue<Integer> queue = new LinkedList<>();
           queue.add(0);
           set.add(0);
           while (!queue.isEmpty()){
               int size = queue.size();
               count++;
               while (size-->0){
                   Integer poll = queue.poll();
                   int sqrt=(int) Math.sqrt(n-poll);
                   for (int i = 1; i <= sqrt; i++) {
                       int sum =poll+(int)Math.pow(i,2);
                       if (sum>n) break;
                       if (sum==n) return count;
                       if (set.contains(sum)) continue;
                       queue.add(sum);
                       set.add(sum);

                   }
               }
           }
           return -1;
       }
    }


    public static void main(String[] args) {
        int sqrt =(int) Math.sqrt(17);
        System.out.println(sqrt);
    }
}
