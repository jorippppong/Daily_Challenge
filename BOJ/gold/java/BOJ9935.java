package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] bombArr = br.readLine().toCharArray();
        char lastChar = bombArr[bombArr.length - 1];

        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            stack.add(c);
            if (c == lastChar) {
                Stack<Character> tempStack = new Stack<>();
                boolean flag = true;
                for (int bombIdx = bombArr.length - 1; bombIdx >= 0; bombIdx--) {
                    if (stack.isEmpty() || stack.peek() != bombArr[bombIdx]) {
                        flag = false;
                        break;
                    }
                    tempStack.add(stack.pop());
                }

                if (!flag) {
                    // temp 복구
                    while (!tempStack.isEmpty()) {
                        stack.add(tempStack.pop());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
