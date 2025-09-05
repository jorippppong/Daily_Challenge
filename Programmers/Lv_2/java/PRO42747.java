package programmers.Lv_2.java;

import java.util.HashMap;
import java.util.Map;

public class PRO42747 {
    public int solution(int[] citations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : citations) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int total = citations.length;
        int hIndex = 0;
        for (int i = 0; i <= 10000; i++) {
            if (total >= i) {
                hIndex = i;
            }
            if (map.containsKey(i)) {
                total -= map.get(i);
            }
        }
        return hIndex;
    }
}
