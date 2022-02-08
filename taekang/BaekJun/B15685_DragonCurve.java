package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15685_DragonCurve{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // K 세대는 K-1세대 드래곤 커브를 끝 점을 기준으로 90도 시계방향 회전
        /**
        0: x좌표가 증가하는 방향 (→)
        1: y좌표가 감소하는 방향 (↑)
        2: x좌표가 감소하는 방향 (←)
        3: y좌표가 증가하는 방향 (↓)
         **/
        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N]; // x 좌표 모음
        int[] y = new int[N]; // y 좌표 모음
        int[] d = new int[N]; // 시작 방향 모음
        int[] g = new int[N]; // 세대 모음

        // if 0이면 -> location[0][0] , location[0][1] 를

        // 3301 (3,3) 시작 시작방향 x좌표가 증가하는 방향

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] str = input.split(" ");
            int x1 = Integer.parseInt(str[0]); // 드래곤 커브의 시작 점, x좌표
            int y1 = Integer.parseInt(str[1]); // 드래곤 커브의 시작 점, y좌표
            int d1 = Integer.parseInt(str[2]); // 시작 방향 (0, 1, 2, 3)
            int g1 = Integer.parseInt(str[3]); // 세대
            x[i] = x1;
            y[i] = y1;
            d[i] = d1;
            g[i] = g1;
        }


    }
}
