package boj.silver.java;

import java.util.*;

public class BOJ1697 {
    private static int MAX = 100_000 * 2;
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        Queue<int[]> q = new LinkedList<>(); // 위치, 시간(초)
        q.add(new int[]{n, 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int loc = curr[0], sec = curr[1];
            if(loc == k){
                System.out.println(sec);
                return;
            }
            if(set.contains(loc)){
                continue;
            }
            set.add(loc);
            if(canGo(loc-1)) q.add(new int[]{loc-1, sec+1});
            if(canGo(loc+1)) q.add(new int[]{loc+1, sec+1});
            if(canGo(loc*2)) q.add(new int[]{loc*2, sec+1});
        }        
    }

    private static boolean canGo(int loc){
        return !set.contains(loc) && loc < MAX;
    }
}
