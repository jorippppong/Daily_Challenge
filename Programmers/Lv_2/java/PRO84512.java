package programmers.Lv_2.java;

public class PRO84512 {
    private int answer = 0;
    private int order = 0;
    private final StringBuilder sb = new StringBuilder();
    private final String[] vowel = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        cal(0, word);
        return answer;
    }

    private void cal(int len, String word) {
        if (word.contentEquals(sb)) {
            answer = order;
        }
        order++;

        if (len == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            sb.append(vowel[i]);
            cal(len + 1, word);
            sb.deleteCharAt(len);
        }
    }
}
