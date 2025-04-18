package boj.silver.java;

import java.util.*;
import java.util.stream.Collectors;

public class BOJ1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        
        String[] nums = input.split("[+-]");
        Deque<Integer> numbers = Arrays.stream(nums)
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Character> operators = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            if (ch == '+' || ch == '-') {
                operators.add(ch);
            }
        }

        int ans = numbers.removeFirst();
        while(!operators.isEmpty()){
            Character op = operators.removeFirst();
            if(op.equals('-')){
                int temp = numbers.removeFirst();
                while(!operators.isEmpty() && operators.peekFirst().equals('+')){
                    operators.removeFirst();
                    temp += numbers.removeFirst();
                }
                ans -= temp;
            }
            else{
                ans += numbers.removeFirst();
            }
        }
        System.out.println(ans);
    }
}
