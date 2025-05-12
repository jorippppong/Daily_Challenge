package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BOJ15666 {
    private static int len;
    private static final TreeSet<Integer> set = new TreeSet<>();
    private static final List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while (n-- > 0) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        backtracking();
    }

    private static void backtracking() {
        int cnt = ans.size();
        if (cnt == len) {
            String str = ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(str);
            return;
        }

        int prev = ans.isEmpty() ? 0 : ans.get(cnt - 1);
        for (int num : set) {
            if (num >= prev) {
                ans.add(num);
                backtracking();
                ans.remove(cnt);
            }
        }
    }
}
