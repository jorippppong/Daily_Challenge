package boj.silver.java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11724 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        while(m-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(i == parent[i]) ans++;
        }
        System.out.println(ans);
    }

    private static void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        parent[Math.max(parentX, parentY)] = Math.min(parentX, parentY);
    }

    private static int find(int x){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
}
