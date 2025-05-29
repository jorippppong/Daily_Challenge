package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1987 {
    private static char[][] arr;
    private static int row;
    private static int col;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final Set<Character> alp = new HashSet<>();
    private static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 백트랙킹
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        alp.add(arr[0][0]);
        backtracking(0, 0);
        System.out.println(ans);
    }

    private static void backtracking(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                char c = arr[nx][ny];
                if (!alp.contains(c)) {
                    alp.add(c);
                    ans = Math.max(ans, alp.size());
                    backtracking(nx, ny);
                    alp.remove(c);
                }
            }
        }
    }
}
