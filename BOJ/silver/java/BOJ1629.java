package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    private static long num;
    private static long modi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        modi = Integer.parseInt(st.nextToken());

        System.out.println(cal(cnt));
    }

    private static long cal(int cnt) {
        if (cnt == 1) {
            return num % modi;
        }
        long half = cal(cnt / 2);
        long ans = half * half % modi;
        return cnt % 2 == 0 ? ans : ans * (num % modi) % modi;
    }
}
