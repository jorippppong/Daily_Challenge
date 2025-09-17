package programmers.Lv_2.java;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PRO86971 {
    public int solution(int n, int[][] wires) {
        boolean[][] board = new boolean[n + 1][n + 1];
        for (int[] w : wires) {
            board[w[0]][w[1]] = true;
            board[w[1]][w[0]] = true;
        }
        int answer = n;

        for (int[] w : wires) {
            board[w[0]][w[1]] = false;
            board[w[1]][w[0]] = false;

            // BFS
            Set<Integer> set = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.add(1);
            set.add(1);
            int cnt = 1;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int i = 1; i <= n; i++) {
                    if (board[node][i] && !set.contains(i)) {
                        q.add(i);
                        set.add(i);
                        cnt++;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));

            // 끝나면 자원 정리
            board[w[0]][w[1]] = true;
            board[w[1]][w[0]] = true;
        }

        return answer;
    }
}
