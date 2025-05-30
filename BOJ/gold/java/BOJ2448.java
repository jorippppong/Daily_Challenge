package boj.gold.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2448 {
    private static final List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // inorder -> postorder
        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.isEmpty()) {
                break;
            }
            arr.add(Integer.parseInt(temp));
        }

        postOrder(0, arr.size() - 1);
    }

    // LRM
    private static void postOrder(int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return;
        }
        if (startIdx == endIdx) {
            System.out.println(arr.get(startIdx));
            return;
        }

        int curr = arr.get(startIdx);
        int boundary = startIdx + 1;
        for (; boundary <= endIdx; boundary++) {
            if (arr.get(boundary) > curr) {
                break;
            }
        }

        postOrder(startIdx + 1, boundary - 1);
        postOrder(boundary, endIdx);
        System.out.println(curr);
    }
}
