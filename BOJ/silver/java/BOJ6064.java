package boj.silver.java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ans = -1;
            for (int year = x; year <= (long) m * n; year += m) {
                int current_y = (year - 1) % n + 1;
                if (current_y == y) {
                    ans = year;
                    break;
                }
            }

            System.out.println(ans);
        }
    }
}
