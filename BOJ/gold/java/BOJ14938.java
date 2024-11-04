// https://www.acmicpc.net/problem/14938

package gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14938 {
    private static final int MAX_VALUE = 15*100;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n, m, r
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // item 갯수
        int[] item = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        // 경로 정보
        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(arr[i], MAX_VALUE);
        }
        for(int i=0; i<n+1; i++){
            arr[i][i] = 0;
        }
        for(; r>0; r--){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[a][b] = cost;
            arr[b][a] = cost;
        }

        // 플로이드-워셜 알고리즘 (수색 범위 최단 경로)
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        // 수색범위가 range 이하 인 지역의 item 총합
        int answer = -1;
        for(int i=1; i<n+1; i++){
            int result = 0;
            for(int j=1; j<n+1; j++){
                if(arr[i][j] <= range){
                    result += item[j];
                }
            }
            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }
}
