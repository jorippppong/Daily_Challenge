package leetcode.easy;

/*
1. 아이디어 : 
DP

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
DP, 반복문
*/

public class LC70 {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i=2; i<n+1; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}