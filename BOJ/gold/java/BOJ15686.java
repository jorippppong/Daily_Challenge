package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15686 {
    private static int maxChicken;
    private static int ans = Integer.MAX_VALUE;
    private static final Set<int[]> house = new HashSet<>();
    private static final Map<Integer, int[]> chickenStore = new HashMap<>();
    private static final List<Integer> combList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        maxChicken = Integer.parseInt(st.nextToken());
        int idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    house.add(new int[]{i, j});
                } else if (x == 2) {
                    chickenStore.put(idx, new int[]{i, j});
                    idx += 1;
                }
            }
        }

        combination();
        System.out.println(ans);
    }

    private static void combination() {
        if (combList.size() == maxChicken) {
            ans = Math.min(ans, calculate());
        }
        int lastIdx = combList.isEmpty() ? -1 : combList.get(combList.size() - 1);
        for (int i = lastIdx + 1; i < chickenStore.size(); i++) {
            combList.add(i);
            combination();
            combList.remove(combList.size() - 1);
        }
    }

    private static int calculate() {
        int total = 0;
        for (int[] curr : house) {
            int minCost = Integer.MAX_VALUE;
            for (int idx : combList) {
                int[] chicken = chickenStore.get(idx);
                int cost = Math.abs(curr[0] - chicken[0]) + Math.abs(curr[1] - chicken[1]);
                minCost = Math.min(minCost, cost);
            }
            total += minCost;
        }
        return total;
    }

}
