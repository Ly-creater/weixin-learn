package com.test.algorithm._01queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.test.algorithm._01queue
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
public class _02OpenLock {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        String cur = "9999";
        for (int j = 0; j < 10000000; j++) {
            for (int i = 0; i < 4; i++) {
                char c = cur.charAt(i);
                String add = cur.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + cur.substring(i + 1);
                String sub = cur.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + cur.substring(i + 1);
            }
        }
        System.out.println(System.currentTimeMillis()-l);
        long w = System.currentTimeMillis();
        for (int j = 0; j < 10000000; j++) {
            for (int i = 0; i < 4; i++) {
                char c = cur.charAt(i);
                String add = cur.substring(0, i) + (c == 9 ? 0 : c  + 1) + cur.substring(i + 1);
                String sub = cur.substring(0, i) + (c == 0 ? 9 : c - 1) + cur.substring(i + 1);
            }
        }
        System.out.println(System.currentTimeMillis()-w);

    }

    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> visited = Stream.of(deadends).collect(Collectors.toSet());
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            int cnt = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                while (n-- > 0) {
                    String cur = queue.poll();
                    if (visited.contains(cur)) continue;
                    if (cur.equals(target)) return cnt;
                    visited.add(cur);
                    for (int i = 0; i < 4; i++) {
                        char c = cur.charAt(i);
                        String add = cur.substring(0, i) + (c == 9 ? 0 : c + 1) + cur.substring(i + 1);
                        String sub = cur.substring(0, i) + (c == 0 ? 9 : c - 1) + cur.substring(i + 1);
                        if (!visited.contains(add)) queue.offer(add);
                        if (!visited.contains(sub)) queue.offer(sub);
                    }
                }
                cnt++;
            }
            return -1;
        }
    }
}

