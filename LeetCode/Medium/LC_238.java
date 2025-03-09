package LeetCode.Medium;

/*
1. 아이디어 : 
첫번째 반복문으로 현재 위치 기준 오른쪽 곱을 구해서 ans 배열 저장하고, 
두번째 반복문으로 현재 위치 기준 왼쪽 곱을 구해서 ans 배열에 곱한다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
DP
*/

public class LC_238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            ans[len-1] = 1;
            // 오른쪽 곱
            for(int i=len-2; i>=0; i--){
                ans[i] = ans[i+1] * nums[i+1];
            }
            // 왼쪽 곱
            int rightProd = 1;
            for(int i=0; i<len; i++){
                ans[i] *= rightProd;
                rightProd *= nums[i];
            }
    
            return ans;
        }
    }
}
