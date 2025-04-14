package boj.silver.java;

import java.util.Scanner;

public class BOJ1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int num = sc.nextInt();
            if(num == 0){
                System.out.println("1 0");
            }
            else if(num == 1){
                System.out.println("0 1");
            }
            else{
                int[] zero = new int[num+1];
                int[] one = new int[num+1];
                zero[0] = 1;
                one[1] = 1;
                for(int i = 2; i<=num; i++){
                    zero[i] = zero[i-1] + zero[i-2];
                    one[i] = one[i-1] + one[i-2];
                }
                System.out.println(zero[num] + " " + one[num]);
            }
        }
        sc.close();
    }
}
