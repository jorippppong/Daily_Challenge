package LeetCode.Easy;

/*
1. 아이디어 : 
i -> 배열을 순회하는 인덱스 
j -> 고유한(중복이 없는) 값을 저장하는 위치
nums[i]와 nums[j]를 비교하여 두 값이 다르면, j를 증가하고 nums[j]에 nums[i]를 저장한다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
투 포인터

*/


public class LC_26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int j = 0;
            int k = 1;
            for(int i=1; i<nums.length; i++){
                if(nums[j] != nums[i]){
                    j++;
                    nums[j] = nums[i];
                    k++;
                }
            }
            return k;
        }
    }
}
