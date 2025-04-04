// https://www.acmicpc.net/problem/10830

package boj.gold.java;

import java.util.Scanner;

public class BOJ10830 {
    static int n;
    static long b;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        b = sc.nextLong();
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 분할 정복
        int[][] result = dnc(b);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result[i][j]%1000 + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    // 분할 정복
    private static int[][] dnc(long exp){
        if(exp == 1){
            return arr;
        }
        int[][] mid = dnc(exp/2);
        int[][] result = calculate(mid, mid);
        // 홀수
        if(exp % 2 == 1){
            return calculate(result, arr);
        }
        // 짝수
        else{
            return result;
        }
    }

    // 행렬 계산
    private static int[][] calculate(int[][] a, int[][] b){
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    result[i][j] += (a[i][k] * b[k][j])%1000;
                }
            }
        }
        return result;
    }
}
