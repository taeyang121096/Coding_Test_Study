package Programmers.lv2;

public class drawPoint {
    public static void main(String[] args) {
        long answer = 0;
        int k = 1;
        int d = 5;

        for (int i = 0; i <= d / k; i++) {
            long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(i, 2) * (long) Math.pow(k, 2)) / k;
            answer += y + 1;
        }

        System.out.println(answer);
    }
}
