// https://www.acmicpc.net/problem/13172

package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13172 {
    static final int X = 1000000007;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long N =1, S=0; // N : 분모, S : 분자
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // 통분 
            S = S*n + s*N;
            N *= n;

            // gcd 구해서 나눠도 됨
            S %= X;
            N %= X;
        }

        // 최종 결과가 기약 분수 인지 아닌지
        if(S % N == 0){
            System.out.println(S/N);
        }
        else{
            System.out.println((cal(N, X-2)*S)%X);
        }
    }

    // 페르마 소정리 : 분자 * 분모^(X-2) mod X 
    static private long cal(long bottom, int exp){
        if(exp == 1){
            return bottom;
        }
        long temp = cal(bottom, exp/2);
        if(exp % 2 == 1){
            return temp * temp % X * bottom % X;
        }
        else{
            return temp * temp % X;
        }
    }

    // GCD
    // static private int gcd(int a, int b){
    //     if(b == 0){
    //         return a;
    //     }
    //     return gcd(b, a%b);
    // }
}
