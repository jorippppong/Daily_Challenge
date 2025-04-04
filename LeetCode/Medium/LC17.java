package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. 아이디어 : 
Backtracking

2. 시간복잡도 : 
(n : digits의 길이)
O(3^n) ~ O(4^n)

3. 자료구조/알고리즘 : 
Backtracking, Map
*/

public class LC17 {
    class Solution {
        private List<String> ans = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.isBlank()) return Collections.emptyList();

            Map<Character, String> digitMap = new HashMap<>();
            digitMap.put('2', "abc");
            digitMap.put('3', "def");
            digitMap.put('4', "ghi");
            digitMap.put('5', "jkl");
            digitMap.put('6', "mno");
            digitMap.put('7', "pqrs");
            digitMap.put('8', "tuv");
            digitMap.put('9', "wxyz");

            StringBuilder sb = new StringBuilder();
            combine(digits, sb, 0, digitMap);
            return ans;
        }

        public void combine(String digits, StringBuilder sb, int idx, Map<Character, String> digitMap){
            if(idx == digits.length()){
                ans.add(sb.toString());
                return;
            }
            String digit = digitMap.get(digits.charAt(idx));
            for(char c : digit.toCharArray()){
                sb.append(c);
                combine(digits, sb, idx+1, digitMap);
                sb.deleteCharAt(idx);
            }
        }
    }
}
