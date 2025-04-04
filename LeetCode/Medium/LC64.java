package leetcode.medium;

/*
1. 아이디어 : 
DP

2. 시간복잡도 : 
O(nm)

3. 자료구조/알고리즘 : 
DP, 반복문
*/

public class LC64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int row = grid.length, col = grid[0].length;
            for(int i=1; i<row; i++) grid[i][0] += grid[i-1][0];
            for(int j=1; j<col; j++) grid[0][j] += grid[0][j-1];
            for(int i=1; i<row; i++){
                for(int j=1; j<col; j++){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
            return grid[row-1][col-1];
        }
    }
}
