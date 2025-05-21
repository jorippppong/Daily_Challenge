package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prevMin = new int[3];
        int[] prevMax = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // min
            int minA = a + Math.min(prevMin[0], prevMin[1]);
            int minB = b + Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
            int minC = c + Math.min(prevMin[1], prevMin[2]);
            prevMin[0] = minA;
            prevMin[1] = minB;
            prevMin[2] = minC;

            // max
            int maxA = a + Math.max(prevMax[0], prevMax[1]);
            int maxB = b + Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
            int maxC = c + Math.max(prevMax[1], prevMax[2]);
            prevMax[0] = maxA;
            prevMax[1] = maxB;
            prevMax[2] = maxC;
        }

        int maxAns = Arrays.stream(prevMax).max().orElse(-1);
        int minAns = Arrays.stream(prevMin).min().orElse(-1);
        System.out.println(maxAns + " " + minAns);
    }
}
