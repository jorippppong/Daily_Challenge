// https://www.acmicpc.net/problem/1043

package gold.java;

import java.util.*;

public class BOJ1043 {
    static int[] parent;

    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);  
        return parent[x];
    }

    static void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX < parentY){
            parent[parentY] = parentX;
        } 
        else if(parentY < parentX){
            parent[parentX] = parentY;
        } 
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람
        int m = sc.nextInt(); // 파티 횟수
        int[][] party = new int[m][]; // 파티 참여 정보
        parent = new int[n+1];
        for(int i=1; i<n+1; i++){
            parent[i] = i;
        }

        int knowCnt = sc.nextInt();
        if(knowCnt == 0){
            System.out.println(m);
            sc.close();
            return;
        }
        int[] know = new int[knowCnt];  // 진실을 아는 사람
        for(int i=0; i<knowCnt; i++){
            know[i] = sc.nextInt();
        }

        for(int i=0; i<m; i++){
            int cnt = sc.nextInt();
            party[i] = new int[cnt];
            for(int j=0; j<cnt; j++){
                party[i][j] = sc.nextInt();
            }
            // union
            for(int j=0; j<cnt-1; j++){
                union(party[i][j], party[i][j+1]);
            }
        }

        // parent knows
        boolean[] parentKnow = new boolean[n+1];
        for(int idx: know){
            parentKnow[find(idx)] = true;
        }

        // 진실을 아는 사람이 한명이라도 있으면 거짓말 불가능
        int result = 0;
        for(int i=0; i<m; i++){
            boolean flag = false;
            for(int j=0; j<party[i].length; j++){
                if(parentKnow[find(party[i][j])]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result ++;
            }
        }

        System.out.println(result);
        sc.close();
    }

}
