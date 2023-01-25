package BOJ;

import java.util.*;
import java.io.*;

public class PuyoPuyo_BOJ {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        while (true) {
            if (!series()) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    static boolean series() {
        int chunk = 0;
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] != '.') {
                    if (bfs(i, j)) {
                        chunk++;
                    }
                }
            }
        }
        if (chunk == 0) {
            return false;
        } else {
            down1();
            return true;
        }
    }

    static boolean bfs(int r, int c) {
        boolean[][] visit = new boolean[12][6];
        visit[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        char ch = arr[r][c];
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dx[i];
                int nc = tmp[1] + dy[i];
                if (nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || visit[nr][nc]) {
                    continue;
                }
                if (ch == arr[nr][nc]) {
                    cnt++;
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        if (cnt >= 4) {
            bomb(visit);
            return true;
        }
        return false;
    }

    static void bomb(boolean[][] visit) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visit[i][j]) {
                    arr[i][j] = '.';
                }
            }
        }
    }

//    static void down() {
//        for (int i = 0; i < 6; i++) {
//            for (int j = 11; j >= 0; j--) {
//                if (arr[j][i] == '.') {
//                    for (int k = j - 1; k >= 0; k--) {
//                        if (arr[k][i] != '.') {
//                            arr[j][i] = arr[k][i];
//                            arr[k][i] = '.';
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//    }

    static void down1() {
        for (int i = 0; i < 6; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if(arr[j][i] != '.')
                    q.offer(arr[j][i]);
            }


            for (int j = 11; j >= 0; j--) {
                if(!q.isEmpty()){
                    arr[j][i] = q.poll();
                } else {
                    arr[j][i] = '.';
                }
            }
        }
    }

}
