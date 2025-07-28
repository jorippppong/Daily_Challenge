package programmers.Lv_1.java;

import java.util.HashMap;
import java.util.Map;

public class PRO42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        for (String c : completion) {
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        for (String remain : map.keySet()) {
            return remain;
        }
        return null;
    }
}
