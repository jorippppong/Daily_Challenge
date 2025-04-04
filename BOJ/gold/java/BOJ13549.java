// https://www.acmicpc.net/problem/13549

package boj.gold.java;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ13549 {
    static int[] value;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        value = new int[100001];
        Arrays.fill(value, -1);

        bfs(n, k);

        sc.close();
    }

    // 가중치가 0이면 가장 앞으로 이동, 가중치가 1이면 가장 뒤로 이동
    static void bfs(int n, int k){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(n);
        value[n] = 0;

        while(!queue.isEmpty()){
            int position = queue.pollFirst();
            if(position == k){
                System.out.println(value[position]);
                return;
            }

            if(position*2 <= 100000 && value[position*2] == -1){
                queue.addFirst(position*2);
                value[position*2] = value[position];
            }
            if(position-1 >= 0 && value[position-1] == -1){
                queue.addLast(position-1);
                value[position-1] = value[position] + 1;
            }
            if(position+1 <= 100000 && value[position+1] == -1){
                queue.addLast(position+1);
                value[position+1] = value[position] + 1;
            }
        }
    }
}

