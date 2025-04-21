package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    private static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int white = count(0, 0, n, 0);
        int blue = count(0, 0, n, 1);
        System.out.println(white);
        System.out.println(blue);
    }

    private static int count(int x, int y, int len, int target){
        if(len == 1){
            return arr[x][y] == target ? 1 : 0;
        }

        int numCnt = 0;
        for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                if(arr[i][j] == target){
                    numCnt++;
                }
            }
        }

        if(numCnt == len*len){
            return 1;
        }
        len /= 2;
        return count(x, y, len, target)
             + count(x+len, y, len, target)
             + count(x, y+len, len, target)
             + count(x+len, y+len, len, target);
    }
}