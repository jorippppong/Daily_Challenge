package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
1. 아이디어 : 
배열을 순회하면서 값이 연속되었는지 여부를 파악한다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
배열, 반복문
*/

public class LC228 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            if(nums.length == 0) return ans;
            int key = nums[0];
            int value = nums[0];
            for(int i=1; i<nums.length; i++){
                if(nums[i] != (nums[i-1]+1)){
                    if(key == value) ans.add(key+"");
                    else ans.add(key+"->"+value);
                    key = nums[i];
                }
                value = nums[i];

            }
            if(key == value) ans.add(key+"");
            else ans.add(key+"->"+value);

            return ans;
        }
    }
}
