package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1. 아이디어 : 
정렬 후 two pointer를 사용해서 적절한 합을 찾는다. 
중복된 조합이 있는 경우에는 그 전의 pointer 값과 비교해서 동일한 경우 skip 한다.

2. 시간복잡도 : 
O(n^2)

3. 자료구조/알고리즘 : 
배열, two pointer 
*/

public class LC15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();

            for(int i=0; i<nums.length-2; i++){
                if(i>0 && nums[i] == nums[i-1]) continue;
                int start = i+1;
                int end = nums.length-1;

                while(start < end && start < nums.length && end > i){
                    if(nums[start] + nums[end] + nums[i] == 0){
                        ans.add(List.of(nums[i], nums[start], nums[end]));

                        while(start < end && nums[start] == nums[start+1]) start++;
                        while(start < end && nums[end] == nums[end-1]) end--;

                        start++;
                        end--;
                    }
                    else if(nums[start] + nums[end] + nums[i] < 0){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
            return ans;
        }
    }
}
