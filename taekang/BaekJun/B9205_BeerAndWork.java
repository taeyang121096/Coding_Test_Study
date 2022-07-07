package BaekJun;

import java.io.*;
import java.util.*;

public class B9205_BeerAndWork {
    static int t;
    static int n;
    static int[][] map;
    static boolean[][] check;

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

    }

    public static void main(String[] args) throws IOException {
        /**
         * 출발 : 상근이네 집, 맥주 한 박스(맥주 2개) 들고 출발
         * 50미터에 한 병씩 마심, 50미터 가려면 맥주 한 병을 "직전"에 마셔야 함
         * 편의점에 들렸을 때 빈 병은 버리고 새 맥주 병을 살 수 있다. 맥주는 한박스 20병 넘길 수 없다
         * 편의점 나선 직전에도 맥주를 마셔야함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine()); // 2
        n = Integer.parseInt(br.readLine()); // 2 n+2 = 4 개줄에는
        map = new int[65536][65536];
        check = new boolean[65536][65536];
        String[] s = br.readLine().trim().split(" "); // 0 0
        map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().trim().split(" ");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            map[r][c] = 1;
        }
        String[] s1 = br.readLine().trim().split(" ");
        map[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])] = 3;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        // 0 0 : 집, 1000 0 : 편의점 1000 1000 : 편의점, 2000 1000 : 페스티벌
        // 0 0 : 집, 5   0  : 편의점 5    5    : 편의점, 10   5    : 페스티벌
        /**
         * 1 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 2 0 0 0 2
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 3
         */
//        bfs(0, 0);
    }


}
