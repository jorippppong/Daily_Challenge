package leetcode.medium;

/*
1. 아이디어 : 
DP
i번째 집을 털 경우: dp[i-2] + nums[i] (i-2번째 집까지 털고 i번째 집을 털기)
i번째 집을 털지 않을 경우: dp[i-1] (i-1번째 집까지 털었을 때의 최대 금액)
둘 중 최댓값을 dp[i]에 저장한다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
DP, 반복문
*/

public class LC198 {
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len+1];
            dp[1] = nums[0];
            for(int i=2; i<=len; i++){
                dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
            }        
            return dp[len];
        }
    }
}