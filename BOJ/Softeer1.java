import java.util.*;

public class Softeer1 {
    public static int mini = Integer.MAX_VALUE;
    public static int maxi = Integer.MIN_VALUE;
    public static int length;
    public static List<String> can = new ArrayList<>();
    public static String[] lst;
    public static boolean[] visited;

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        lst = str.split(" ");
        sc.close();

        // 입력 조건 확인 
        length = lst.length;
        boolean haveThree = false;
        for(int i =0; i<length; i++){
            if(lst[i].length() > 3 || Integer.parseInt(lst[i]) == 0){
                System.out.print("-1");
                return;
            }
            else if(lst[i].length() == 3){
                haveThree = true;
            }
        }
        if(haveThree){
            if(length > 6){
                System.out.print("-1");
                return;
            }
        } else{
            if(length > 9){
                System.out.print("-1");
                return;
            }
        }

        // BT
        visited = new boolean[length];
        BT(0);
        System.out.print(mini+maxi);
    }

    public static void BT(int idx){
        if(idx == length){
            String a = "";
            for(String s:can){
                a += s;
            }
            //System.out.println(a);
            int num = Integer.parseInt(a);
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
            return;
        }

        for(int i=0; i<length; i++){
            if(visited[i] == false){
                can.add(lst[i]);
                visited[i] = true;
                BT(idx+1);
                can.remove(can.size() -1);
                visited[i] = false;
            }
        }
    }
}
