package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int cnt = 0;
            int row = matrix.length, col = matrix[0].length;
            boolean[][] visited = new boolean[row][col];
            int cx = 0, cy = 0;
            int dir = 0;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            while(true){
                if(cnt == row*col) break;
                ans.add(matrix[cx][cy]);
                visited[cx][cy] = true;
                cnt++;
                if(!inRange(cx+dx[dir], cy+dy[dir], row, col) || visited[cx+dx[dir]][cy+dy[dir]] == true){
                    dir = (dir+1)%4;
                }
                cx += dx[dir];
                cy += dy[dir];
            }

            return ans;
        }

        public boolean inRange(int x, int y, int row, int col){
            return x>=0 && x<row && y>=0 && y<col;
        }
    }
}