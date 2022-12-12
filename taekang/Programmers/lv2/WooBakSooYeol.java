package Programmers.lv2;

import java.util.*;

public class WooBakSooYeol {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};

        ArrayList<Integer> list = new ArrayList<>(); // 5, 16, 8, 4, 2, 1
        int ar_k = k;
        list.add(ar_k);
        int cnt = 0;
        while (ar_k != 1) {
            // 짝수라면 2로 나눔
            if (ar_k % 2 == 0) {
                ar_k /= 2;
            }
            // 홀수라면 3을 곱하고 1을 더함
            else {
                ar_k *= 3;
                ar_k += 1;
            }
            cnt++;
            list.add(ar_k);
        }

        ArrayList<Double> area_list = new ArrayList<>();
        area_list.add(0.0);
        double area = 0.0;
        for (int i = 0; i < list.size() - 1; i++) {
            double a = (double) list.get(i + 1);// 16
            double b = (double) list.get(i); // 8
            area += Math.abs(a - b) / 2 + Math.min(a,b);
            area_list.add(area);
        }

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int x = ranges[i][0]; // 0
            int y = ranges[i][1] + cnt; // 0

            // s부터 e까지 정적분(넓이)
            if (y > x) {
                answer[i] = area_list.get(y) - area_list.get(x);
            } else if (x > y) {
                answer[i] = -1.0;
            } else {
                answer[i] = 0.0;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
