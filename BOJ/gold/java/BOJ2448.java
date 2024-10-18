// https://www.acmicpc.net/problem/2448

package gold.java;

import java.util.Scanner;

public class BOJ2448 {
    static int n;
    static int center;
    static byte[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new byte[n+1][2*n]; // 1 : *
        center = n;
        int depth = 3;

        arr[1][center] = 1;
        arr[2][center-1] = 1;
        arr[2][center+1] = 1;
        for(int j=center-2; j<=center+2; j++){
            arr[3][j] = 1;
        }

        while(depth < n){
            setValue(depth+1, center-depth, depth);
            setValue(depth+1, center+depth, depth);
            depth *= 2;
        }

        printResult(n+1, 2*n);
        sc.close();
    }

    static void setValue(int x, int y, int depth){
        for(int i=0; i<depth; i++){
            for(int j=-depth+1; j<depth; j++){
                arr[i+x][j+y] = arr[i+1][j+center];
            }
        }
    }

    static void printResult(int h, int w){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                if(arr[i][j] == 1){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            if(i==h-1){
                continue;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

