package programmers.Lv_3.java;

import java.util.*;

public class PRO42579 {
    public List solution(String[] genres, int[] plays) {
        // 장르
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());
        genreList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // 장르 별 곡
        Map<String, PriorityQueue<int[]>> playMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            if (!playMap.containsKey(genres[i])) {
                playMap.put(genres[i], new PriorityQueue<>((a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return b[0] - a[0];
                }));
            }
            playMap.get(genres[i]).add(new int[]{plays[i], i}); // {수록곡, 고유번호}
        }

        // 결과 저장 및 출력
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey();
            PriorityQueue<int[]> pq = playMap.get(genre);
            int cnt = 2;
            while (!pq.isEmpty() && cnt > 0) {
                ans.add(pq.poll()[1]);
                cnt--;
            }
        }
        return ans;
    }
}
