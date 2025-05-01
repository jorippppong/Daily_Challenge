package boj.gold.java;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0){
            char[] cmds = br.readLine().toCharArray();
            Integer.parseInt(br.readLine());
            LinkedList<Integer> dq = Arrays.stream(br.readLine().replaceAll("[\\[\\]]", "").split(","))
                                .map(String::trim)
                                .filter(s -> !s.isEmpty())
                                .map(Integer::parseInt)
                                .collect(Collectors.toCollection(LinkedList::new));
            
            boolean isForward = true;
            boolean isError = false;
            for(char cmd : cmds){
                if(cmd == 'R'){
                    isForward = !isForward;
                }
                else{
                    if(dq.isEmpty()){
                        isError = true;
                        break;
                    }
                    
                    if(isForward){
                        dq.removeFirst();
                    }
                    else{
                        dq.removeLast();
                    }
                }
            }

            // 출력
            if(isError){
                sb.append("error");
            }
            else{
                sb.append("[");
                while(!dq.isEmpty()){
                    sb.append(isForward ? dq.removeFirst() : dq.removeLast());
                    if(!dq.isEmpty()) sb.append(",");
                }
                sb.append("]");
            }
            sb.append("\n");
        }
    
        System.out.println(sb);
    }
}
