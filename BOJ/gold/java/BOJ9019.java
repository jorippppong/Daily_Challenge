package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    private static final int MAX = 10_000;
    private static final char[] ops = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int source = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[MAX];
            int[] parent = new int[MAX];
            int[] cmd = new int[MAX];

            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            visited[source] = true;
            parent[source] = -1;

            while (!q.isEmpty()) {
                int num = q.poll();
                if (num == target) {
                    // 문자열 출력
                    StringBuilder sb = new StringBuilder();
                    int curr = target;
                    while (parent[curr] != -1) {
                        sb.append(ops[cmd[curr]]);
                        curr = parent[curr];
                    }
                    System.out.println(sb.reverse());
                    break;
                }

                int[] dslr = new int[4];
                dslr[0] = num * 2 % 10000;
                dslr[1] = num == 0 ? 9999 : num - 1;
                dslr[2] = (num % 1000) * 10 + num / 1000;
                dslr[3] = num / 10 + (num % 10) * 1000;
                for (int i = 0; i < 4; i++) {
                    int next = dslr[i];
                    if (!visited[next]) {
                        visited[next] = true;
                        parent[next] = num;
                        cmd[next] = i;
                        q.add(next);
                    }
                }
            }
        }
    }
}
