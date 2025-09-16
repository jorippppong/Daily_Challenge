package programmers.Lv_2.java;

public class PRO42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        int maxIdx = 0;
        int maxNumber = number.charAt(maxIdx) - '0';
        int length = number.length();

        while (end < length && k > 0 && start + k < length) {
            if (end - start < k) {
                end++;
                int v = number.charAt(end) - '0';
                if (v > maxNumber) {
                    maxNumber = v;
                    maxIdx = end;
                }
                continue;
            }

            sb.append(maxNumber);
            k -= (maxIdx - start);
            start = maxIdx + 1;
            end = start;
            maxIdx = start;
            maxNumber = start < length ? number.charAt(maxIdx) - '0' : 0;
        }

        for (int i = start; i < length - k; i++) {
            sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}
