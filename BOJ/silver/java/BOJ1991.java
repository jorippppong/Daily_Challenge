package boj.silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1991 {
    private static final Map<Character, Character> leftChild = new HashMap<>();
    private static final Map<Character, Character> rightChild = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left != '.') {
                leftChild.put(node, left);
            }
            if (right != '.') {
                rightChild.put(node, right);
            }
        }

        System.out.println(preorder('A'));
        System.out.println(inorder('A'));
        System.out.println(postorder('A'));
    }

    private static String preorder(char node) {
        String m = String.valueOf(node);
        String l = leftChild.containsKey(node) ? preorder(leftChild.get(node)) : "";
        String r = rightChild.containsKey(node) ? preorder(rightChild.get(node)) : "";
        return m + l + r;
    }

    private static String inorder(char node) {
        String l = leftChild.containsKey(node) ? inorder(leftChild.get(node)) : "";
        String m = String.valueOf(node);
        String r = rightChild.containsKey(node) ? inorder(rightChild.get(node)) : "";
        return l + m + r;
    }

    private static String postorder(char node) {
        String l = leftChild.containsKey(node) ? postorder(leftChild.get(node)) : "";
        String r = rightChild.containsKey(node) ? postorder(rightChild.get(node)) : "";
        String m = String.valueOf(node);
        return l + r + m;
    }
}
