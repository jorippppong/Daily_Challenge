package leetcode.hard;

import java.util.Stack;

/*
1. 아이디어 : 
Stack
괄호의 쌍이 나오면 괄호 안에 있는 식을 계산하고 stack에 넣는다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
Stack
*/

public class LC224 {
    class Solution {
        public int calculate(String s) {
            s = s.replace(" ", "");
            s = "("+s+")";

            Stack<String> mainCal = new Stack<>();
            Stack<String> subCal = new Stack<>();
            Integer num = 0;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(' || c == '+' || c == '-'){
                    mainCal.push(c+"");
                }
                else if(c == ')'){
                    while(!mainCal.peek().equals("(")){
                        subCal.push(mainCal.pop());
                    }
                    mainCal.pop(); // "(" 제거
                    mainCal.push(cal(subCal));
                }
                else{
                    // 숫자이면,
                    num = num * 10 + (c - '0');
                    if(!Character.isDigit(s.charAt(i+1))){
                        mainCal.push(num+"");
                        num = 0;
                    }
                }
            }

            return Integer.parseInt(mainCal.pop());
        }

        private String cal(Stack<String> subCal){
            Integer num;
            if(subCal.peek().equals("-")){
                num = 0;
            }
            else{
                num = Integer.parseInt(subCal.pop());
            }
            while(!subCal.isEmpty()){
                String s = subCal.pop();
                if(s.equals("+")){
                    num += Integer.parseInt(subCal.pop());
                }
                else if(s.equals("-")){
                    num -= Integer.parseInt(subCal.pop());
                }
            }
            return num+"";
        }
    }
}
