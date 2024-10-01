// https://www.acmicpc.net/problem/14719

import java.util.Scanner;

public class BOJ14719 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        boolean[][] block = new boolean[H][W];
        for(int i =0; i<W; i++){
            int height = sc.nextInt();
            for(int j=height; j<H; j++){
                block[j][i] = true; 
            }
        }
        sc.close();
        
        int answer = 0;
        for(int h= 0; h<H; h++){
            int start = 0;
            int end = W-1;
            for(; start<W; start++){
                if(block[h][start] == false){
                    break;
                }
            }
            for(; end>=0; end--){
                if(block[h][end] == false){
                    break;
                }
            }

            // 블록 없음
            if(start == W-1 || end == 0){
                break;
            }
            // 블록 하나
            else if(start == end){
                break;
            }
            else{
                for(int i=start; i<end; i++){
                    if(block[h][i]) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}