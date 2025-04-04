// https://www.acmicpc.net/problem/15663

package boj.silver.java;

import java.util.*;
import java.util.stream.Collectors;

public class BOJ15663 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        perm(0);

        sc.close();
    }

    public static void perm(int size){
        if(size == m){
            String result = stack.stream().map(String::valueOf).collect(Collectors.joining(" "));
            if(!set.contains(result)){
                set.add(result);
                System.out.println(result);
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                stack.push(arr[i]);
                visited[i] = true;
                perm(size+1);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}