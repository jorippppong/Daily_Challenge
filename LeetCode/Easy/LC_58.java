package LeetCode.Easy;

/*
1. 아이디어 : 
반복문

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
반복문
*/

public class LC_58 {
    class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            int ans = 0;
            for(int i=s.length()-1; i>=0; i--){
                if(s.charAt(i) != ' '){
                    ans++;
                }
                else{
                    break;
                }
            }
            return ans;
        }
    }
}
