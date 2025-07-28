package programmers.Lv_1.java;

public class PRO86491 {
    public int solution(int[][] sizes) {
        int maxX = -1;
        int maxY = -1;
        for (int[] size : sizes) {
            maxX = Math.max(maxX, Math.max(size[0], size[1]));
            maxY = Math.max(maxY, Math.min(size[0], size[1]));
        }
        return maxX * maxY;
    }
}
