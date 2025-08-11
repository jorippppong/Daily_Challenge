package programmers.Lv_1.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PRO42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> overlap = new HashSet<>(lostSet);
        overlap.retainAll(reserveSet);
        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);

        int lostCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i)) {
                if (reserveSet.contains(i - 1)) {
                    reserveSet.remove(i - 1);
                    continue;
                }
                if (reserveSet.contains(i + 1)) {
                    reserveSet.remove(i + 1);
                    continue;
                }
                lostCnt++;
            }
        }
        return n - lostCnt;
    }
}
