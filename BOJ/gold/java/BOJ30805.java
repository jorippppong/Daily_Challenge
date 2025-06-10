package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ30805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // {num 내림, idx 오름}
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> {
            if (v1[0] == v2[0]) {
                return v1[1] - v2[1];
            }
            return v2[0] - v1[0];
        });
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.add(new int[]{num, i});
        }

        // Map<num, {idx 오름}>
        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, TreeSet<Integer>> bMap = new HashMap<>();
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!bMap.containsKey(num)) {
                bMap.put(num, new TreeSet<>());
            }
            bMap.get(num).add(i);
        }

        int prevAIdx = -1;
        int prevBIdx = -1;
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int num = curr[0], idx = curr[1];
            if (idx < prevAIdx) {
                continue;
            }

            // 공통 문자가 없으면
            if (!bMap.containsKey(num)) {
                continue;
            }
            int bIdx = -1;
            TreeSet<Integer> treeSet = bMap.get(num);
            for (Integer i : treeSet) {
                if (i > prevBIdx) {
                    bIdx = i;
                    break;
                }
            }
            if (bIdx == -1) {
                continue;
            }

            // 공통 문자가 있으면
            prevAIdx = idx;
            prevBIdx = bIdx;
            ans.add(num);
        }

        System.out.println(ans.size());
        if (ans.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Integer num : ans) {
                sb.append(num)
                        .append(" ");
            }
            System.out.println(sb);
        }

    }
}
