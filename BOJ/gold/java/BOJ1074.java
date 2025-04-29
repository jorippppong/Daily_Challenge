package boj.gold.java;

import java.io.*;
import java.util.Scanner;

public class BOJ1074 {
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        row = sc.nextInt();
        col = sc.nextInt();
        sc.close();

        divide4(0, 0, n, 0);
    }

    private static void divide4(int x, int y, int n, int cnt){
        if(n == 0){
            if(x == row && y == col){
                System.out.println(cnt);
            }
            return;
        }

        // 4등분 중 어느 구역에 있는지 확인
        n -= 1;
        int len = (int) Math.pow(2, n);
        int section = len*len;
        if(inRange(x, y, len)){
            divide4(x, y, n, cnt);
        }
        else if(inRange(x, y+len, len)){
            divide4(x, y+len, n, cnt + section);
        }
        else if(inRange(x+len, y, len)){
            divide4(x+len, y, n, cnt + 2*section);
        }
        else if(inRange(x+len, y+len, len)){
            divide4(x+len, y+len, n, cnt + 3*section);
        }
    }

    private static boolean inRange(int x, int y, int len){
        return row >= x && row < x + len && col >= y && col < y + len;
    }
}
