package silver.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
1. 아이디어 : 
bit masking or set

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
bit masking or set
*/

public class BOJ11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        
        int bitmask = 0;
        while(m>0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int x = 0;

            if(!command.equals("all") && !command.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case "add":
                    bitmask |= (1 << x);
                    break;
                case "remove":
                    bitmask &= ~(1 << x);
                    break;
                case "check":
                    sb.append((bitmask & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitmask ^= (1 << x);
                    break;
                case "all":
                    bitmask = (1 << 21) -1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
            m--;
        }
        System.out.print(sb);
    }


    public static void main2(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        while(m>0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int x = 0;

            if(!command.equals("all") && !command.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);  
                    break;
                case "check":
                    sb.append(set.contains(x) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if(set.contains(x)){
                        set.remove(x);
                    }
                    else{
                        set.add(x);
                    }
                    break;
                case "all":
                    set.clear();
                    set.addAll(IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toSet()));
                    break;
                case "empty":
                    set.clear();
                    break;
            }
            m--;
        }
        System.out.print(sb);
    }
}
