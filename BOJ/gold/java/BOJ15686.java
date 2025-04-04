// https://www.acmicpc.net/problem/15686

package boj.gold.java;

import java.util.*;

public class BOJ15686 {
    static int minValue = Integer.MAX_VALUE;
    static int houseCnt = 0;
    static int chickenCnt = 0;
    static HashMap<Integer, Pair> house = new HashMap<>();
    static HashMap<Integer, Pair> chicken = new HashMap<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        // 0은 빈 칸, 1은 집, 2는 치킨집
        // 치킨집이 m개 일 때, 도시의 치킨 거리의 최소
        // M <= 치킨집 <= 13, 1 <= 집 < 2N
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = sc.nextInt();
                if(num == 1){
                    houseCnt++;
                    house.put(houseCnt, new Pair(i, j));
                }
                else if(num == 2){
                    chickenCnt++;
                    chicken.put(chickenCnt, new Pair(i, j));
                }
            }
        }

        comb(m, 0);
        System.out.println(minValue);
        
        sc.close();
    }

    static void comb(int total, int cnt){
        if(cnt == total){
            minValue = Math.min(minValue, calChickenValue(new ArrayList<>(stack)));// 최솟값 구하기
            return;
        }

        int lastIdx = 0;
        if(!stack.isEmpty()){
            lastIdx = stack.peek();
        }
        for(int i=lastIdx+1; i<=chickenCnt ;i++){
            stack.add(i);
            comb(total, cnt+1);
            stack.pop();
        }
    }

    static int calChickenValue(List<Integer> comb){
        int result = 0;
        for(int i =1; i<=houseCnt; i++){
            int houseMin = Integer.MAX_VALUE;
            Pair housePair = house.get(i);
            for(int chickenIdx: comb){
                Pair chickenPair = chicken.get(chickenIdx);
                int cal = Math.abs(housePair.x - chickenPair.x) + Math.abs(housePair.y - chickenPair.y);
                houseMin = Math.min(houseMin, cal);
            }
            result += houseMin;

        }
        return result;
    }

    static class Pair{
        int x;
        int y;
    
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
