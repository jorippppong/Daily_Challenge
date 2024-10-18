// https://www.acmicpc.net/problem/5639

package gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ5639 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] visited;
    static HashMap<Integer, Integer> left = new HashMap<>();
    static HashMap<Integer, Integer> right = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
			String temp = br.readLine();
			
			if(temp == null || temp.equals(""))break;
            arr.add(Integer.parseInt(temp));
		}

        visited = new boolean[10001];
        visited[0] = true;

        makeOrder(0);
        postOrder(arr.get(0));
    }

    private static void makeOrder(int idx){
        int currValue = arr.get(idx);
        int leftIdx = 10000;
        int rightIdx = 10000;
        for(int i=idx+1; i<arr.size(); i++){
            if(visited[i]){
                break;
            }
            if(arr.get(i) < currValue){
                leftIdx = Math.min(leftIdx, i);
            }
            else if(arr.get(i) > currValue){
                rightIdx = Math.min(rightIdx, i);
            }
        }

        visited[leftIdx] = true;
        visited[rightIdx] = true;

        if(leftIdx < 10000){
            left.put(currValue, arr.get(leftIdx));
            makeOrder(leftIdx);
        }
        if(rightIdx < 10000){
            right.put(currValue, arr.get(rightIdx));
            makeOrder(rightIdx);
        }
    }

    private static void postOrder(int node){
        if(left.containsKey(node)){
            postOrder(left.get(node));
        }
        if(right.containsKey(node)){
            postOrder(right.get(node));
        }
        System.out.println(node);
    }
}
