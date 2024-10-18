// https://www.acmicpc.net/problem/1629

package silver.java;

import java.util.Scanner;

public class BOJ1629 {
    static long a;
    static long b;
    static long c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(mod(b));

        sc.close();
    }

    // a^x 를 c로 나눈 나머지를 반환
    static long mod(long x){
        if(x == 1){
            return a % c;
        }
        long num = 1;
        if(x%2 != 0){
            num *= a;
        }
        long result = mod(x/2);
        result = (result * result) % c;
        return (result * num) % c;
    }
}
