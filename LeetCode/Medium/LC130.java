package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
1. 아이디어 : 
BFS를 사용해서 edge에 있는 O를 A로 마킹한다. 
그 결과로 edge에 있는 O는 A로 마킹되고, X 내부에 있는 O는 O로 마킹된 상태 그대로 남는다.
이중 반복문을 사용해서 board를 순회하면서, A -> O, O -> X 로 마킹한다.

2. 시간복잡도 : 
O(nm)

3. 자료구조/알고리즘 : 
BFS
*/

public class LC130 {
    class Solution {
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            
            // BFS, edge에 있는 O -> A 로 변환
            Queue<int[]> q = new LinkedList<>(); // [row, col]
            for(int i=0; i<row; i++){
                if(board[i][0] == 'O') q.add(new int[]{i, 0});
                if(board[i][col-1] == 'O') q.add(new int[]{i, col-1});
            }
            for(int j=1; j<col-1; j++){
                if(board[0][j] == 'O') q.add(new int[]{0, j});
                if(board[row-1][j] == 'O') q.add(new int[]{row-1, j});
            }
            while(!q.isEmpty()){
                int[] b = q.poll();
                int cx = b[0], cy = b[1];
                if(board[cx][cy] == 'A') continue;

                board[cx][cy] = 'A';
                for(int k=0; k<4; k++){
                    int nx = cx + dx[k], ny = cy + dy[k];
                    if(inRange(nx, ny, row, col) && board[nx][ny] == 'O'){
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            // 최종적으로 (A -> O, O -> X)
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(board[i][j] == 'A') board[i][j] = 'O';
                    else if(board[i][j] == 'O') board[i][j] = 'X';
                }
            }
        }

        public boolean inRange(int x, int y, int row, int col){
            return x>=0 && x<row && y>=0 && y<col;
        }
    }
}