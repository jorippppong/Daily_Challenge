package programmers.Lv_3.java;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PRO42627 {
    public int solution(int[][] jobs) {
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.workTime == b.workTime) {
                if (a.askTime == b.askTime) {
                    return a.idx - b.idx;
                }
                return a.askTime - b.askTime;
            }
            return a.workTime - b.workTime;
        });
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int idx = 0;
        int currentTime = 0;
        int sum = 0;
        int cnt = 0;
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= currentTime) {
                pq.add(new Task(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) {
                currentTime += 1;
                continue;
            }
            Task task = pq.poll();
            currentTime += task.workTime;
            sum += (currentTime - task.askTime);
            cnt++;
        }

        return (sum) / jobs.length;
    }

    private static class Task {
        int idx;
        int askTime;
        int workTime;

        public Task(int idx, int askTime, int workTime) {
            this.idx = idx;
            this.askTime = askTime;
            this.workTime = workTime;
        }
    }
}
