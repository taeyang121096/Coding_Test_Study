package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B1025 {
    public static int N, M, cnt = 0, answer = Integer.MIN_VALUE;
    public static int[][] map;
    public static List<Integer> r_add = new ArrayList<>();
    public static List<Integer> c_add = new ArrayList<>();
    public static List<int[]> comb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 6
        M = Integer.parseInt(st.nextToken()); // 7
        map = new int[N][M];
        /**
         * 행과 열이 등차수열...
         * r : ...-(N-1) -2 -1 +0 +1 +2 +(N-1)...
         * c : ...-(M-1) -2 -1 +0 +1 +2 +(M-1) ...
         */
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        getComb();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[] k : comb) {
                    int dx = k[0]; // +1
                    int dy = k[1]; // +3
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    int idx_x = i;
                    int idx_y = j;
                    int sum = map[i][j];
                    if (isTrue(sum)) {
                        cnt++;
                        answer = Math.max(answer, sum);
                    }
                    while (true) {
                        idx_x += dx;
                        idx_y += dy;
                        if (idx_x >= N || idx_y >= M || idx_x < 0 || idx_y < 0) {
                            break;
                        }
                        sum *= 10;
                        sum += map[idx_x][idx_y];

                        if (isTrue(sum)) {
                            cnt++;
                            answer = Math.max(answer, sum);
                        }
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        } else
            System.out.println(answer);
    }

    public static boolean isTrue(int num) {
        int tmp = (int) Math.sqrt(num);
        if (tmp * tmp == num) {
            return true;
        } else {
            return false;
        }
    }

    public static void getComb() {
        for (int i = 0; i <= N; i++) {
            r_add.add(i);
        }
        for (int i = 1; i <= N; i++) {
            r_add.add(-i);
        }
        // -(N-1)...0...+(N-1)
        for (int i = 0; i <= M; i++) {
            c_add.add(i);
        }
        for (int i = 1; i <= M; i++) {
            c_add.add(-i);
        }

        for (int i = 0; i < r_add.size(); i++) {
            for (int j = 0; j < c_add.size(); j++) {
                comb.add(new int[]{r_add.get(i), c_add.get(j)});
            }
        }
    }
}
