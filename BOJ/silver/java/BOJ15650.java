package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ15650 {
    private static int n;
    private static int m;
    private static final List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        backtracking();
    }

    private static void backtracking() {
        if (ans.size() == m) {
            String str = ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(str);
            return;
        }

        int prev = ans.isEmpty() ? 0 : ans.get(ans.size() - 1);
        for (prev += 1; prev <= n; prev++) {
            ans.add(prev);
            backtracking();
            ans.remove(ans.size() - 1);
        }
    }
}
