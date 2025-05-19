package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        // 인접 리스트 (+ map)
        Map<Integer, Integer>[] arr = new HashMap[city + 1];
        for (int i = 0; i <= city; i++) {
            arr[i] = new HashMap<>();
        }
        for (int j = 0; j < bus; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start].put(end, Math.min(arr[start].getOrDefault(end, Integer.MAX_VALUE), cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        int[] minCost = new int[city + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));  // {cost, location}
        pq.add(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], location = curr[1];
            if (minCost[location] < cost) continue;  // 이미 갱신 완료
            for (Map.Entry<Integer, Integer> entry : arr[location].entrySet()) {
                if (cost + entry.getValue() < minCost[entry.getKey()]) {
                    pq.add(new int[]{cost + entry.getValue(), entry.getKey()});
                    minCost[entry.getKey()] = cost + entry.getValue();
                }
            }
        }

        System.out.println(minCost[end]);
    }
}
