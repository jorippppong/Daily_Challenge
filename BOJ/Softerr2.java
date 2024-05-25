import java.util.*;

public class Softerr2 {
    // 'a' = 97
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String command = sc.next();
		String key = sc.next();
		int rotate = sc.nextInt();
		String message = sc.next();
        int length = key.length();
		sc.close();

        int keys[] = new int[length];
        for(int i=0; i<length; i++){
            keys[i] = (int)key.charAt(i) - 97;
            System.out.print(keys[i]);
        }
        int messages[] = new int[length];
        for(int i =0; i<length; i++){
            messages[i] = (int)message.charAt(i) - 97;
            System.out.print(messages[i]);
        }

        int answer[] = new int[length];
        // 암호화
        if(command.equals("encrypt")){
            for(int i=0; i<length; i++){
                answer[i] = (keys[i] + messages[i]) % 26;
                //System.out.print(answer[i]);   // FOR CHECK
            }
            // rotate
            rotate = ((rotate % length) + length)%length;
            String result = "";
            for(int i=0; i<length; i++){
                result += (char)(answer[rotate]+97);
                rotate = (rotate+1)%length;
            }
            System.out.print(result);
        }
        // 복호화 
        else if(command.equals("decrypt")){
            rotate = -rotate;
            rotate = ((rotate % length) + length)%length;
            for(int i=0; i<length; i++){
                answer[i] = messages[rotate];
                rotate = (rotate+1)%length;
            }
            for(int i=0; i<length; i++){
                answer[i] = ((answer[i] - keys[i]) + 26) %26;
            }
            String result = "";
            for(int i=0; i<length; i++){
                result += (char)(answer[i] + 97);
            }
            System.out.println(result);
        }
    }
}
