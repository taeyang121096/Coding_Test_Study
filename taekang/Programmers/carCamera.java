package Programmers;

import java.util.*;

public class carCamera {
    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        int e = -30001;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > e) {
                answer++;
                e = routes[i][1];
            }
        }
    }
}
