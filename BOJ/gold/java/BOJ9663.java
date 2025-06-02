package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    private static int n;
    private static boolean[] col;
    private static boolean[] diaAdd;
    private static boolean[] diaSub;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        diaAdd = new boolean[2 * n];
        diaSub = new boolean[2 * n];

        backtracking(0);
        System.out.println(ans);
    }

    private static void backtracking(int x) {
        if (x == n) {
            ans += 1;
            return;
        }

        for (int y = 0; y < n; y++) {
            if (!col[y] && !diaAdd[x + y] && !diaSub[x - y + n]) {
                col[y] = true;
                diaAdd[x + y] = true;
                diaSub[x - y + n] = true;

                backtracking(x + 1);

                col[y] = false;
                diaAdd[x + y] = false;
                diaSub[x - y + n] = false;
            }
        }
    }
}
