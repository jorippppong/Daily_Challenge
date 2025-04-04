package leetcode.easy;

/*
1. 아이디어 : 
Bit Manipulation
같은 숫자를 2번 XOR 하면, 원래 숫자로 돌아온다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
Bit Manipulation
*/

public class LC136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for(int num:nums){
                ans ^= num;
            }
            return ans;
        }
    }
}