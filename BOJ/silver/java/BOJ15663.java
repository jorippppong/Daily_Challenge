package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ15663 {
    private static int len;
    private static final TreeMap<Integer, Integer> map = new TreeMap<>();
    private static final List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        backtracking(0);
    }

    private static void backtracking(int cnt) {
        if (cnt == len) {
            String str = ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(str);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > 0) {
                ans.add(key);
                map.put(key, value - 1);
                backtracking(cnt + 1);
                ans.remove(ans.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}
