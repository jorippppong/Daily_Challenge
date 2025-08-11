package programmers.Lv_2.java;

import java.util.HashMap;
import java.util.Map;

public class PRO42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        return answer - 1;
    }
}
