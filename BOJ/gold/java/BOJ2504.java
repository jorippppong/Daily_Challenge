// https://www.acmicpc.net/problem/2504

package gold.java;

import java.util.*;

public class BOJ2504 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();;

        /**
         * (, [ : value에 x2, x3히고  push
         * ), ] : 
         *  a. 스텍 비어 있거나 나의 짝꿍이 아니면 return 0
         *  b. 짝꿍 만나면 pop, 내가 가장 안쪽에 있던 괄호만 result += value 진행
         */
        int value = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
                value *= 2;
            }
            else if(c == '['){
                stack.push(c);
                value *= 3; 
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0;
                    break;
                }
                else{
                    stack.pop();
                    if(str.charAt(i-1) == '(') result += value;
                    value /= 2;
                }
            }
            else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    result = 0;
                    break;
                }
                else{
                    stack.pop();
                    if(str.charAt(i-1) == '[') result += value;
                    value /= 3;
                }
            }
        }
        if(!stack.isEmpty()) result = 0;
        System.out.print(result);
    }
}
