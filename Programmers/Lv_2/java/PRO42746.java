package programmers.Lv_2.java;

import java.util.Arrays;

public class PRO42746 {
    public String solution(int[] numbers) {
        String[] sNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(sNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (sNumbers[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : sNumbers) {
            sb.append(s);
        }
        return sb.toString();
    }
}
