package programmers.Lv_2.java;

import java.util.ArrayList;
import java.util.List;

public class PRO87946 {
    private final List<Integer> lst = new ArrayList<>();
    private int[][] dungeons;
    private boolean[] visited;
    private int power = 0;
    private int answer = 0;

    public int solution(int k, int[][] dungeonsParam) {
        power = k;
        dungeons = dungeonsParam;
        visited = new boolean[dungeonsParam.length];

        perm(0, dungeons.length);

        return answer;
    }

    private void perm(int cnt, int size) {
        if (cnt == size) {
            calculate();
            return;
        }
        for (int i = 0; i < visited.length; i++) {
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
        int p = power;
        int cnt = 0;
        for (int idx : lst) {
            if (dungeons[idx][0] <= p) {
                p -= dungeons[idx][1];
                cnt++;
            } else {
                break;
            }
        }
        answer = Math.max(answer, cnt);
    }

}
