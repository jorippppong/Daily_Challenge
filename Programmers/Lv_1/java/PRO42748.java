package programmers.Lv_1.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PRO42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            List<Integer> temp = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                temp.add(array[i]);
            }
            Collections.sort(temp);
            ans[idx] = temp.get(command[2] - 1);
            idx += 1;
        }
        return ans;
    }
}
