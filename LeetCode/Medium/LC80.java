package leetcode.medium;

/*
1. 아이디어 :
i -> 배열을 순회하는 인덱스 
j -> 값(최대 2번 저장 가능)을 저장하는 위치
nums[i]와 nums[j]를 비교하여 두 값이 다르면, j를 증가하고 nums[j]에 nums[i]를 저장한다.
twice라는 flag를 사용하여 값이 두번 이상 저장되면, 더 저장하지 못하도록 제한한다.

2. 시간복잡도 :
O(n)

3. 자료구조/알고리즘 :
투 포인터
*/

public class LC80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            boolean twice = false;
            int j = 0;
            int slot = 1;
            for(int i=1; i<nums.length; i++){
                if(nums[i] != nums[j]){
                    twice = false;
                    j++;
                    nums[j] = nums[i];
                    slot++;
                }
                else{
                    if(twice){
                        continue;
                    }
                    else{
                        twice = true;
                        j++;
                        nums[j] = nums[i];
                        slot++;
                    }
                }
            }
            return slot;
        }
    }
}
