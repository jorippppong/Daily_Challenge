package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ15652 {
    private static int n;
    private static int m;
    private static final List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtracking(0);
    }

    private static void backtracking(int size) {
        if (size == m) {
            String s = ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(s);
            return;
        }

        int prev = size == 0 ? 1 : ans.get(size - 1);
        for (; prev <= n; prev++) {
            ans.add(prev);
            backtracking(size + 1);
            ans.remove(size);
        }
    }
}
