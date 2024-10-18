// https://www.acmicpc.net/problem/1991

package silver.java;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1991 {
    static int n;
    static int[][] arr;
    static Stack<Integer> preStack = new Stack<>();
    static Stack<Integer> inStack = new Stack<>();
    static Stack<Integer> postStack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        arr = new int[n][3];
        for(int k = 0; k<n; k++){
            // A : 65 -> 0
            String line = sc.nextLine();
            String[] chars = line.split(" ");
            int i = (int)chars[0].charAt(0) - 65;
            arr[i][0] = i;
            for(int j=1; j<=2; j++){
                if(chars[j].equals(".")){
                    arr[i][j] = -1;
                } else{
                    arr[i][j] = (int)chars[j].charAt(0) - 65;
                }
            }
        }

        preorder(0);
        printResult(preStack);
        inorder(0);
        printResult(inStack);
        postorder(0);
        printResult(postStack);

        sc.close();
    }

    static void preorder(int idx){
        preStack.push(idx);
        if(arr[idx][1]!=-1){
            preorder(arr[idx][1]);
        }
        if(arr[idx][2]!=-1){
            preorder(arr[idx][2]);
        }
    }

    static void inorder(int idx){
        if(arr[idx][1]!=-1){
            inorder(arr[idx][1]);
        }
        inStack.push(idx);
        if(arr[idx][2]!=-1){
            inorder(arr[idx][2]);
        }
    }

    static void postorder(int idx){
        if(arr[idx][1]!=-1){
            postorder(arr[idx][1]);
        }
        if(arr[idx][2]!=-1){
            postorder(arr[idx][2]);
        }
        postStack.push(idx);
    }

    static void printResult(Stack<Integer> stack){
        StringBuffer str = new StringBuffer();
        for(Integer num:stack){
            str.append((char)(num+65));
        }
        System.out.println(str);
    }
}
