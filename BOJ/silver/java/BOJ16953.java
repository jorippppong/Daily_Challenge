package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long source = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());

        Set<Long> set = new HashSet<>();
        Queue<long[]> q = new LinkedList<>(); // {num, cnt}
        q.add(new long[]{source, 1});
        set.add(source);
        while (!q.isEmpty()) {
            long[] curr = q.poll();
            long num = curr[0], cnt = curr[1];
            if (num == target) {
                System.out.println(cnt);
                return;
            }

            long next = num * 2;
            if (!set.contains(next) && next <= target) {
                q.add(new long[]{next, cnt + 1});
                set.add(next);
            }
            next = num * 10 + 1;
            if (!set.contains(next) && next <= target) {
                q.add(new long[]{next, cnt + 1});
                set.add(next);
            }
        }
        System.out.println(-1);
    }
}
