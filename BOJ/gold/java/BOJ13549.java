package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13549 {
    private static final int MIN_LOCATION = 0;
    private static final int MAX_LOCATION = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int source = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{source, 0}); // {위치, 시간}
        set.add(source);
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int location = curr[0], sec = curr[1];
            if (location == target) {
                System.out.println(sec);
                return;
            }

            int next = location * 2;
            if (next >= MIN_LOCATION && next <= MAX_LOCATION && !set.contains(next)) {
                dq.addFirst(new int[]{next, sec});
                set.add(next);
            }
            next = location - 1;
            if (next >= MIN_LOCATION && next <= MAX_LOCATION && !set.contains(next)) {
                dq.add(new int[]{next, sec + 1});
                set.add(next);
            }
            next = location + 1;
            if (next >= MIN_LOCATION && next <= MAX_LOCATION && !set.contains(next)) {
                dq.add(new int[]{next, sec + 1});
                set.add(next);
            }
        }

    }
}
