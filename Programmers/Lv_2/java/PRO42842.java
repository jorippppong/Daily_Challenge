package programmers.Lv_2.java;

public class PRO42842 {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int width = yellow / i;  // 가로
                int length = i;  // 세로

                if (brown == ((width + 2) * (length + 2) - yellow)) {
                    return new int[]{width + 2, length + 2};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
