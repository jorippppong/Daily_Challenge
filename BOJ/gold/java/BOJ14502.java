// https://www.acmicpc.net/problem/14502

package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int n;
    static int m;
    static int[][] arr;
    static ArrayList<Pair> walls;
    static int ans = 0;
    static Stack<Integer> stack = new Stack<>();
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽이 세워질 수 있는 공간 찾기 
        walls = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0){
                    walls.add(new Pair(i, j));
                }
            }
        }

        combination(0);
        System.out.println(ans);
    }

    // 조합으로 벽 새울 수 있는 경우 확인
    private static void combination(int size){
        if(size == 3){
            int cal = virus();
            ans = Math.max(ans, cal);
            return;
        }
        int lastIdx = stack.size() == 0 ? -1 : stack.peek();
        for(int i=lastIdx+1; i<walls.size(); i++){
            stack.add(i);
            combination(size+1);
            stack.pop();
        }
    }

    // 새로운 벽 세우기
    private static int virus(){
        int[][] area = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                area[i][j] = arr[i][j];
            }
        }
        
        for(int idx : stack){
            Pair p = walls.get(idx);
            area[p.x][p.y] = 1;
        }
        
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(area[i][j] == 2 && visited[i][j] == false){
                    visited[i][j] = true;
                    infection(area, i, j, visited);
                }
            }
        }

        return safeArea(area);
    }

    // 바이러스 감염 (동서남북으로 이동) 
    private static void infection(int[][] area, int x, int y, boolean[][] visited){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && area[nx][ny] == 0){
                area[nx][ny] = 2;
                visited[nx][ny] = true;
                infection(area, nx, ny, visited);
            }
        }
    }


    // 안전공간 찾음 (0 갯수)
    private static int safeArea(int[][] area){
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(area[i][j]==0){
                    result += 1;
                }
            }
        }
        
        return result;
    }

    private static boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

    private static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
