package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ15654 {
    private static int n;
    private static int m;
    private static final List<Integer> ans = new ArrayList<>();
    private static final List<Integer> arr = new ArrayList<>();
    private static final boolean[] visited = new boolean[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }
        Collections.sort(arr);

        backtracking(0);
    }

    private static void backtracking(int size) {
        if (size == m) {
            String s = ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(s);
            return;
        }

        for (int idx = 0; idx < n; idx++) {
            if (visited[idx]) continue;
            ans.add(arr.get(idx));
            visited[idx] = true;
            backtracking(size + 1);
            ans.remove(size);
            visited[idx] = false;
        }
    }
}
