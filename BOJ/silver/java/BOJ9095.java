package boj.silver.java;

import java.util.Scanner;

public class BOJ9095 {
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            ans = 0;
            perm(0, n);
            System.out.println(ans);
        }
        sc.close();
    }

    // 1, 2, 3이 무수히 많은 순열
    private static void perm(int num, int target){
        if(num == target){
            ans++;
            return;
        }
        else if(num > target){
            return;
        }
        for(int i=1; i<=3; i++){
            perm(num+i, target);
        }
    }
}
