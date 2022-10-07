package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B7573 {
    public static int N, l, M;
    public static ArrayList<int[]> list = new ArrayList<>();
//    public static int[][] dir = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static int getFishNum(int i, int j, int nextX, int nextY) {
        int cnt = 0;
        for (int k = 0; k < M; k++) {
            if (list.get(i)[0] <= list.get(k)[0] &&
                    list.get(k)[0] <= list.get(i)[0] + nextX &&
                    list.get(j)[1] <= list.get(k)[1] &&
                    list.get(k)[1] <= list.get(j)[1] + nextY) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 모눈종이의 크기
        l = Integer.parseInt(st.nextToken()); // 그물의 길이
        M = Integer.parseInt(st.nextToken()); // 물고기의 수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list.add(new int[]{a, b}); // 물고기가 있는 좌표를 저장 , 각 인덱스 -1 -1
        }

        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k < l / 2; k++) {
                    //두개를 지정해서 던져주고, 그물의 길이 가로 세로 를 던져준다.
                    max = Math.max(max, getFishNum(i, j, k, l / 2 - k));
                }
            }
        }

        System.out.println(max);
//        int max = 0;
//
//        for (int i = 1; i < L / 2; i++) { // 5
//            int height = i; // 가로 길이
//            int weight = L / 2 - i; // 세로 길이
//
////            for (int j = 0; j < list.size(); j++) {
////                int[] coor = list.get(j); // 좌표 를 꺼내와서
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < N; k++) {
//                    for (int[] d : dir) { // 가로 세로에 해당하는 dir 에 height weight 를 곱해서 그물이 갈 수 있는 끝 좌표를 구해줌
//                        int nr = i + d[0] * height; // 더해진 좌표
//                        int nc = j + d[1] * weight; // 더해진 좌표
//                        if (nr >= 0 && nc >= 0 && nr <= N && nc <= N) { // 그물의 끝 좌표가 이에 해당되면
//                            max = Math.max(max, getFishNum(i, j, nr, nc)); // 함수를 돌림
//                        }
//                    }
//                }
//            }
//
////            }
//        }
//
//        System.out.print(max);
    }

//    public static int getFishNum(int r, int c, int nr, int nc) {
//        // 만약 r이 nr보다 크면 r nr 값을 스위치 해줌
//        if (r > nr) {
//            int tmp = r; // 1
//            r = nr; // 0
//            nr = tmp; // 1
//        }
//        // 이하 동문
//        if (c > nc) {
//            int tmp = c;
//            c = nc;
//            nc = tmp;
//        }
//
//        int cnt = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int[] coor = list.get(i); // 전체 좌표가
//
//            int x = coor[0];
//            int y = coor[1];
//
//            // 전체 좌표가 이 범위에 포함되면 cnt를 해줌
//            if (x >= r && x <= nr && y >= c && y <= nc) {
//                cnt++;
//            }
//        }
//
//        return cnt;
//    }
}
