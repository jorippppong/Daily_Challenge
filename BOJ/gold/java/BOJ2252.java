package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력
        List<Integer>[] greater = new List[n + 1];  // 나보다 키 큰 학생 저장
        for (int i = 1; i <= n; i++) {
            greater[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];  // 나보다 작은 학생 몇명 인지
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            greater[a].add(b);
            indegree[b] += 1;
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int num = q.poll();
            ans.add(num);
            for (int g : greater[num]) {
                indegree[g] -= 1;
                if (indegree[g] == 0) {
                    q.add(g);
                }
            }
        }

        String result = ans.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
