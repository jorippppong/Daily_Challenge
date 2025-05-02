package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }

        Deque<int[]> dq = new LinkedList<>();
        boolean[] visited = new boolean[101];
        dq.add(new int[]{1, 0}); // {위치, 주사위 몇번 던졌는지}
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int loc = curr[0], cnt = curr[1];
            if (loc == 100) {
                System.out.println(cnt);
                return;
            }

            if (loc > 100 || visited[loc]) continue;
            visited[loc] = true;

            for (int i = 6; i >= 1; i--) {
                int next = loc + i;
                if (next <= 100 && !visited[next]) {
                    if (map.containsKey(next)) {
                        dq.add(new int[]{map.get(next), cnt + 1});
                    } else {
                        dq.add(new int[]{next, cnt + 1});
                    }
                }
            }
        }
    }
}
