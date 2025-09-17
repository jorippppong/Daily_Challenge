package programmers.Lv_2.java;

import java.util.Arrays;

public class PRO42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        int answer = 0;
        while (start <= end) {
            if (start == end) {
                answer++;
                return answer;
            }

            if (people[start] + people[end] <= limit) {
                answer++;
                start++;
                end--;
            } else {
                answer++;
                end--;
            }
        }

        return answer;
    }
}
