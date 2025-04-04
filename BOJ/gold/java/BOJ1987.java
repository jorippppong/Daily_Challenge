// https://www.acmicpc.net/problem/1987

package boj.gold.java;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ1987 {
    static int r;
    static int c;
    static int[][] arr;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static HashSet<Integer> set = new HashSet<>();
    static int result = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        arr = new int[r][c];
        for(int i =0; i<r; i++){
            String str = sc.nextLine();
            for(int j=0; j<c; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        go(0, 0, 1);
        System.out.println(result);

        sc.close();
    }

    static void go(int x, int y, int cost){
        if(set.contains(arr[x][y])){
            result = Math.max(result, cost-1);
            return;
        }
        set.add(arr[x][y]);
        for(int i=0; i<4; i++){
            if(inRange(x+dx[i], y+dy[i])){
                go(x+dx[i], y+dy[i], cost+1);
            }
        }
        set.remove(arr[x][y]);
    }

    static boolean inRange(int x, int y){
        return x>=0 && x<r && y>=0 && y<c;
    }
}
