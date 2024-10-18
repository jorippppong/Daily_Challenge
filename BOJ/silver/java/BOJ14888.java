// https://www.acmicpc.net/problem/14888

package silver.java;

import java.util.*;

public class BOJ14888{
    public static List<Integer> answers = new ArrayList<>();
    public static Deque<Integer> operOrder = new ArrayDeque<>();
    public static int N;
    public static int[] nums;
    public static int[] opers = new int[4];

    // backtracking
    public static void BT(int idx, int N){
        if(idx == N-1){
            answers.add(calculate());
            return;
        }
        for(int i = 0; i<4; i++){
            if(opers[i] > 0){
                opers[i] -= 1;
                operOrder.addLast(i);
                BT(idx+1, N);
                opers[i] += 1;
                operOrder.removeLast();
            }
        }
    }

    public static int calculate(){
        int result = nums[0];
        Integer[] arr = operOrder.toArray(new Integer[0]);
        for(int i=1; i<N; i++){
            if(arr[i-1] == 0){
                result += nums[i];
            }
            else if(arr[i-1] == 1){
                result -= nums[i];
            }
            else if(arr[i-1] == 2){
                result *= nums[i];
            }
            else{
                result /= nums[i];
            }
        }
        //System.out.println(result);
        return result;
    }
    
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for(int i =0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++){
            opers[i] = sc.nextInt();
        }
        sc.close();

        // backtracking
        BT(0, N);
        
        // 결과 출력
        System.out.println(Collections.max(answers));
        System.out.println(Collections.min(answers));
    }
}