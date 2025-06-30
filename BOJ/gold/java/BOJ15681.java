package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15681 {
    private static List<Integer>[] childTree;
    private static int[] subTreeCnt;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int headNode = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        List<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int j = 0; j < n - 1; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int[] testCase = new int[tc];
        for (int i = 0; i < tc; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
        }

        // tree 구성
        childTree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            childTree[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(headNode);
        visited[headNode] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int childNode : arr[node]) {
                if (!visited[childNode]) {
                    childTree[node].add(childNode);
                    q.add(childNode);
                    visited[childNode] = true;
                }
            }
        }

        // subTreeCnt 계산
        subTreeCnt = new int[n + 1];
        cntSubTree(headNode);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int node : testCase) {
            sb.append(subTreeCnt[node])
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static int cntSubTree(int node) {
        int sum = 1;
        for (int childNode : childTree[node]) {
            sum += cntSubTree(childNode);
        }
        subTreeCnt[node] = sum;
        return sum;
    }
}
