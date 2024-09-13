// https://www.acmicpc.net/problem/15666

import java.util.*;
import java.util.stream.Collectors;

public class BOJ15666 {
    static int m;
    static int depth;
    static Integer[] arr;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        depth = sc.nextInt();
        
        // set -> list
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<m; i++){
            set.add(sc.nextInt());
        }
        arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);  // 오름차순 정렬

        comb(0);

        sc.close();
    }

    // 조합
    public static void comb(int curr){
        if(curr == depth){
            String str = stack.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(str);
            return;
        }
        // 인덱스 찾고, 해당 인덱스 이상
        int idx;
        if(stack.isEmpty()){
            idx = 0;
        } else{
            idx = Arrays.asList(arr).indexOf(stack.peek());
        }
        for(int i = idx; i<arr.length; i++){
            stack.push(arr[i]);
            comb(curr+1);
            stack.pop();
        }
    }
}
