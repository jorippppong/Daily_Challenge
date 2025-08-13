package programmers.Lv_3.java;

import java.util.TreeMap;

public class PRO42628 {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int num = Integer.parseInt(operation.substring(2));
                map.put(num, map.getOrDefault(num, 0) + 1);
                continue;
            }

            if (!map.isEmpty()) {
                int num;
                if (operation.equals("D 1")) {
                    num = map.lastKey();
                } else {
                    num = map.firstKey();
                }
                int cnt = map.get(num);
                if (cnt == 1) {
                    map.remove(num);
                } else {
                    map.put(num, cnt - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
}
