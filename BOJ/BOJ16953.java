// https://www.acmicpc.net/problem/16953

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Value{
    long num;
    long cnt;

    Value(long num, long cnt){
        this.num = num;
        this.cnt = cnt;
    }
}

public class BOJ16953 {
    static Queue<Value> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();

        queue.add(new Value(a, 1));
        System.out.println(bfs(b));

        sc.close();
    }

    static long bfs(long b){
        while(!queue.isEmpty()){
            Value value = queue.poll();
            if(value.num == b){
                return value.cnt;
            }
            
            long num1 = value.num*2;
            if(num1 <= b){
                queue.add(new Value(num1, value.cnt+1));
            }

            long num2 = value.num*10 + 1;
            if(num2 <= b){
                queue.add(new Value(num2, value.cnt+1));
            }
        }

        return -1;
    }
}
