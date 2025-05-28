package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int partyCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int truth = Integer.parseInt(st.nextToken());
        List<Integer> truthPerson = new ArrayList<>();
        for (int i = 0; i < truth; i++) {
            truthPerson.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] party = new ArrayList[partyCnt];  // 파티 참여한 사람 저장
        List<Integer>[] person = new ArrayList[n + 1];   // 어느 파티에 참여했는지 저장
        for (int i = 0; i <= n; i++) {
            person[i] = new ArrayList<>();
        }
        for (int i = 0; i < partyCnt; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                int p = Integer.parseInt(st.nextToken());
                party[i].add(p);
                person[p].add(i);
            }
        }

        // BFS
        Queue<Integer> q = new LinkedList<>(); // 진실만을 말할수 있는 파티
        boolean[] visited = new boolean[partyCnt];
        for (int p : truthPerson) {
            for (int partyNum : person[p]) {
                q.add(partyNum);
                visited[partyNum] = true;
            }
        }
        while (!q.isEmpty()) {
            int currParty = q.poll();
            for (int p : party[currParty]) {
                for (int partyNum : person[p]) {
                    if (!visited[partyNum]) {
                        q.add(partyNum);
                        visited[partyNum] = true;
                    }
                }
            }
        }

        // 결론
        int ans = partyCnt;
        for (int i = 0; i < partyCnt; i++) {
            if (visited[i]) {
                ans -= 1;
            }
        }
        System.out.println(ans);

    }
}
