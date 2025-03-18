package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

/*
1. 아이디어 : 
BFS

2. 시간복잡도 : 
O(nm)

3. 자료구조/알고리즘 : 
BFS, Queue
*/

public class LC_200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int ans = 0;
            int row = grid.length, col = grid[0].length;
            int[][] d = {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(grid[i][j] == '1'){
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        while(!q.isEmpty()){
                            int[] curr = q.poll();
                            int cx = curr[0], cy = curr[1];
                            if(cx < 0 || cx >= row || cy < 0 || cy >= col || grid[cx][cy] != '1'){
                                continue;
                            }
                            grid[cx][cy] = '0';
                            for(int k=0; k<4; k++){
                                int nx = cx + d[k][0], ny = cy + d[k][1];
                                q.offer(new int[]{nx, ny});
                            }
                        }
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
