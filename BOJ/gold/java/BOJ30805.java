// https://www.acmicpc.net/problem/30805

package boj.gold.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ30805 {
    static int n;
    static int[] a;
    static int m;
    static int[] b;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int aIdx = -1;
    static int bIdx = -1;

    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        b = new int[m];
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 계산
        while(cal());

        // 출력
        System.out.println(ans.size());
        if(ans.size() != 0){
            System.out.println(ans.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
            );
        }
    }


    static boolean cal(){
        // aIdx, bIdx 이후의 값 중에 가장 큰 공통 값 찾기 (거꾸로 탐색)
        int maxNum = -1;
        int newAIdx = aIdx; int newBIdx = bIdx;
        for(int i=a.length -1; i>aIdx; i--){
            for(int j=b.length-1; j>bIdx; j--){
                // 겹치는 값이 존재하면, 기존의 값 보다 큰지 비교 -> 크다면 인덱스 갱신
                if(a[i] == b[j] && a[i] >= maxNum){
                    maxNum = a[i];
                    newAIdx = i;
                    newBIdx = j;
                }
            }
        }

        // 공통 값이 없으면..?
        if(maxNum == -1){
            return false;
        }
        // 공통 값이 있으면
        ans.add(maxNum);
        aIdx = newAIdx;
        bIdx = newBIdx;
        return true;
    }

}
