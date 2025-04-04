// https://www.acmicpc.net/problem/9663

package boj.gold.java;

import java.util.Scanner;

public class BOJ1966 {
    static int n;
    static int result = 0;
    static boolean[] rowVisited;
    static boolean[] colVisited;
    static boolean[] rightDiaVisited; // \ (row-col 동일)
    static boolean[] leftDiaVisited;  // / (row+col 동일)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rowVisited = new boolean[n];
        colVisited = new boolean[n];
        rightDiaVisited = new boolean[2*n-1];
        leftDiaVisited = new boolean[2*n-1];

        nQueen(0);
        System.out.println(result);

        sc.close();
    }

    /*
     * i 행에서 nQueen이 가능한 자리를 찾는다.
     */
    private static void nQueen(int i){
        if(i == n){
            result++;
            return;
        }
        for(int j =0; j<n; j++){
            if(canQueen(i, j)){
                setting(i, j);
                nQueen(i+1);
                unsetting(i, j);
            }
        }
    }

    private static boolean canQueen(int x, int y){
        if(rowVisited[x]){
            return false;
        }
        if(colVisited[y]){
            return false;
        }
        if(rightDiaVisited[x-y+(n-1)]){
            return false;
        }
        if(leftDiaVisited[x+y]){
            return false;
        }
        return true;
    }

    public static void setting(int x, int y){
        rowVisited[x] = true;
        colVisited[y] = true;
        rightDiaVisited[x-y+(n-1)] = true;
        leftDiaVisited[x+y] = true;
    }

    public static void unsetting(int x, int y){
        rowVisited[x] = false;
        colVisited[y] = false;
        rightDiaVisited[x-y+(n-1)] = false;
        leftDiaVisited[x+y] = false;
    }
}