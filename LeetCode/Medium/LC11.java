package leetcode.medium;

/*
1. 아이디어 : 
양 끝에서 시작해서 height가 작은걸 움직인다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
two pointer, greedy
*/

public class LC11 {
    class Solution {
        public int maxArea(int[] height) {
            int start = 0, end = height.length-1;
            int ans = 0;
            while(start < end){
                ans = Math.max(ans, (end - start) * Math.min(height[end], height[start]));
                if(height[end] <= height[start]){
                    end--;
                }
                else{
                    start++;
                }
            }
            return ans;
        }
    }
}