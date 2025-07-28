package programmers.Lv_1.java;

import java.util.ArrayList;
import java.util.List;

public class PRO42840 {
    public List<Integer> solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] sums = new int[4];
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == one[i % one.length]) {
                sums[1] += 1;
            }
            if (answer == two[i % two.length]) {
                sums[2] += 1;
            }
            if (answer == three[i % three.length]) {
                sums[3] += 1;
            }
        }
        int maxSum = -1;
        for (int i = 1; i <= 3; i++) {
            maxSum = Math.max(maxSum, sums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (sums[i] == maxSum) {
                ans.add(i);
            }
        }
        return ans;
    }
}
