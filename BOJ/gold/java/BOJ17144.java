// https://www.acmicpc.net/problem/17144

package gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 {
    static int row;
    static int col;
    static int time;
    static int[][] arr; 
    static int bottom;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1){
                    bottom = i;
                }
            }
        }

        for(int i=0; i<time; i++){
            arr = spread();  // 미세먼지 확산
            APwork();  // 공기 청정기 작동 
        }

        System.out.println(countDust());
    }

    // 공기 청정기 작동
    private static void APwork(){
        // 위 구역 (시계 반대 방향)
        int top = bottom -1;
        for(int x=top-1; x>0 ; x--){
            arr[x][0] = arr[x-1][0];
        }
        for(int y=0; y<col-1; y++){
            arr[0][y] = arr[0][y+1];
        }
        for(int x=0; x<top; x++){
            arr[x][col-1] = arr[x+1][col-1];
        }
        for(int y=col-1; y>0; y--){
            arr[top][y] = arr[top][y-1];
        }
        arr[top][1] = 0;

        // 아래 구역 (시계 방향)
        for(int x=bottom+1; x<row-1; x++){
            arr[x][0] = arr[x+1][0];
        }
        for(int y=0; y<col-1; y++){
            arr[row-1][y] = arr[row-1][y+1];
        }
        for(int x=row-1; x>bottom; x--){
            arr[x][col-1] = arr[x-1][col-1];
        }
        for(int y=col-1; y>0; y--){
            arr[bottom][y] = arr[bottom][y-1];
        }
        arr[bottom][1] = 0;
        
    }

    // 미세먼지 확산
    private static int[][] spread(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] dust = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] == -1 || arr[i][j] == 0) continue;
                
                int cnt = 0;
                int divDust = arr[i][j]/5;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(canSpread(nx, ny)){
                        cnt += 1;
                        dust[nx][ny] += divDust;
                    }
                }

                dust[i][j] += (arr[i][j] - (divDust*cnt));
            }
        }
        dust[bottom-1][0] = -1;
        dust[bottom][0] = -1;

        return dust;
    }

    // 미세먼지 확산 가능한지 확인
    private static boolean canSpread(int x, int y){
        // 공기 청정기 위치이면 
        if(y == 0){
            if(x == bottom || x == bottom -1){
                return false;
            }
        }
        // 범위 밖으로 넘어가면
        return x>=0 && x<row && y>=0 && y<col;
    }

    // 미세 먼지 count
    private static int countDust(){
        int ans = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans += arr[i][j];
            }
        }
        return ans + 2;  // 공기청정기의 -1 2개 제외
    }

}
