package leetcode.easy;

/*
1. 아이디어 : 
i -> 배열을 순회하는 인덱스 
curr -> 값을 저장할 위치
nums[i]와 val을 비교하여 두 값이 다르면, nums[curr]에 nums[i]를 저장한다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
투 포인터
*/

public class LC27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int k = 0;
            int curr = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i] != val){
                    nums[curr] = nums[i];
                    curr++; k++;
                }
            }
            return k;
        }
    }
}
