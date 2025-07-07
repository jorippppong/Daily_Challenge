package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            // 입력 & 부분합
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // two pointer (start 부터 end 까지의 합)
        int minLen = n + 1;
        int start = 1;
        int end = 1;
        while (start <= end && end <= n) {
            int partSum = sum[end] - sum[start - 1];
            if (partSum < s) {
                end += 1;
            } else {
                minLen = Math.min(minLen, end - start + 1);
                if (start == end) {
                    start += 1;
                    end += 1;
                } else {
                    start += 1;
                }
            }
        }
        System.out.println(minLen == n + 1 ? 0 : minLen);
    }
}
