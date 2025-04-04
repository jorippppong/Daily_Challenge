// https://www.acmicpc.net/problem/16236

package boj.gold.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16236_2 {
    static int n;
    static int[][] arr;
    static int currX;
    static int currY;
    static int time = 0;
    static int size = 2;
    static int cnt = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    arr[i][j] = 0;
                    currX = i;
                    currY = j;
                }
            }
        }
        
        while(findFood()){}
        
        System.out.println(time);
    }

    // find & eat food
    static boolean findFood(){
        // DFS로 각 위치까지 갈 수 있는 최단거리 계산
        int[][] dp = new int[n][n];  // 각 위치로 갈 수 있는 최단거리 계산
        for(int[] i:dp) Arrays.fill(i, Integer.MAX_VALUE);
        dp[currX][currY] = 0;
        dfs(currX, currY, 0, dp);

        // 먹을 수 있는 물고기 탐색 (물고기 사이즈보다 작아야 하고, 최단거리 & 위 & 왼쪽)
        int minLen = Integer.MAX_VALUE;
        int nextX = n;
        int nextY = n;
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(arr[i][j] > 0 && arr[i][j] < size){
                    // 최단거리 & 위 & 왼쪽
                    if(dp[i][j] <= minLen){
                        minLen = dp[i][j];
                        nextX = i;
                        nextY = j;
                    }
                }
            }
        }

        // 먹을 수 있는 물고기가 없으면
        if(nextX == n && nextY == n){
            return false;
        }
        // 먹을 수 있는 물고기가 있으면
        arr[nextX][nextY] = 0;
        currX = nextX; currY = nextY;
        time += dp[nextX][nextY];
        cnt++;
        if(cnt == size){
            size++;
            cnt = 0;
        }
        return true;
    }

    // DFS
    static void dfs(int x, int y, int len, int[][] dp){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 물고기 크기보다 작거나 같고, 최단 거리 갱신이 가능 할 때
            if(inRange(nx, ny) && arr[nx][ny] <= size && len+1 < dp[nx][ny]){
                dp[nx][ny] = len + 1;
                dfs(nx, ny, len+1, dp);
            }
        }
    }

    static boolean inRange(int x, int y){
        return x>=0 && x<n && y>= 0 && y<n;
    }
}
