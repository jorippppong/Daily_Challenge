package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1. 아이디어 : 
Backtracking
sum이 target보다 크거나 같으면 재귀를 중단한다.

2. 시간복잡도 : 
O(n^t)

3. 자료구조/알고리즘 : 
Backtracking, 리스트
*/

public class LC_39 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cand = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(0, 0, target, candidates);
            return ans;
        }

        public void backtracking(int idx, int sum, int target, int[] candidates){
            if(sum == target){
                ans.add(new ArrayList<>(cand));
            }
            if(sum >= target) return;
            for(int i=idx; i<candidates.length; i++){
                cand.add(candidates[i]);
                backtracking(i, sum+candidates[i], target, candidates);
                cand.remove(cand.size()-1);
            }
        }
    }
}
