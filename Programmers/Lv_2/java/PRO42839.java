package programmers.Lv_2.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PRO42839 {
    private int[] numbers;
    private boolean[] visited;
    private int length;
    private final List<Integer> lst = new ArrayList<>();
    private final Set<Integer> set = new HashSet<>();
    private int answer = 0;

    public int solution(String numbersParam) {
        length = numbersParam.length();
        char[] numChar = numbersParam.toCharArray();
        numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = numChar[i] - '0';
        }
        visited = new boolean[length];

        perm(0, length);

        return answer;
    }

    private void perm(int cnt, int size) {
        calculate();

        if (cnt == size) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                lst.add(i);
                visited[i] = true;
                perm(cnt + 1, size);
                lst.remove(lst.size() - 1);
                visited[i] = false;
            }
        }
    }

    private void calculate() {
        int number = 0;
        for (int idx : lst) {
            number *= 10;
            number += numbers[idx];
        }

        if (!set.contains(number) && isPrime(number)) {
            answer++;
            set.add(number);
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int n = 2; n <= Math.sqrt(number); n++) {
            if (number % n == 0) {
                return false;
            }
        }
        return true;
    }

}
