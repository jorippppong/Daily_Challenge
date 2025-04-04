// https://www.acmicpc.net/problem/9935

package boj.gold.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    static Stack<Pair> stack = new Stack<>();
    static String str;
    static String bomb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();
        
        for(int i=0; i<str.length(); i++){
            // push 
            push(i);
            
            // pop
            if(stack.peek().order == bomb.length()-1){
                pop(bomb.length()-1);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            for(Pair p:stack){
                sb.append(str.charAt(p.index));
            }
            System.out.println(sb);
        }
    }

    private static void pop(int order){
        stack.pop();

        if(order > 0){
            pop(order-1);
        }
    }

    private static void push(int i){
        char c = str.charAt(i);
        int order = -1;
        if(!stack.isEmpty() && stack.peek().order != -1){
            if(c == bomb.charAt(stack.peek().order+1)){
                order = stack.peek().order+1;
                stack.push(new Pair(order, i));
                return;
            }
        }
        if(c == bomb.charAt(0)){
            order = 0;
        }
        stack.push(new Pair(order, i));
    }

    private static class Pair{
        int order;  // 0부터 시작
        int index;

        Pair(int order, int index){
            this.order = order;
            this.index = index;
        }
    }
}
