package BaekJun;

import java.io.*;
import java.util.*;

/**
 * N*N
 * 선생님들은 상하좌우 4가지 방향으로 감시 진행함, 복도에 장애물위치하면 안보임, 멀리있더라도 장애물로 막히기 전 학생들 모두 볼 수 있음
 */
public class B18428 {
    public static int N, cnt = 0;
    public static char[][] map;
    public static int[][] arr;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static List<int[]> list = new ArrayList<>(); //

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        arr = new int[3][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    list.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);

        if (cnt > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs(int depth, int idx) {
        if (depth == 3) {
//            for (int i = 0; i < 3; i++) {
//                System.out.print(arr[i][0] + "," + arr[i][1] + " ");
//            }
//            System.out.println();
            if (goTo(arr)) { // 학생을 만남
                cnt++;
            }
            return;
        }
        for (int i = idx; i < list.size(); i++) {
            arr[depth] = list.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    public static boolean goTo(int[][] arr) {
        char[][] copyMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            copyMap[arr[i][0]][arr[i][1]] = 'O';
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(copyMap[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] == 'T') { // [0,4] [1,0] [3,1] [4,2]
                    // r-1인 방향으로
                    for (int k = i - 1; k >= 0; k--) { // [3,1], k = 2 1 0
                        if (copyMap[k][j] == 'O') { // [2,1] [1,1] [0,1]
                            break;
                        } else if (copyMap[k][j] == 'S') {
                            return false;
                        }
                    }
                    // r + 1인 방향으로
                    for (int k = i + 1; k < N; k++) { // [3,1] [4]
                        if (copyMap[k][j] == 'O') {
                            break;
                        } else if (copyMap[k][j] == 'S') {
                            return false;
                        }
                    }
                    // c -1인 방향으로
                    for (int k = j - 1; k >= 0; k--) { // [3,1] k = 0
                        if (copyMap[i][k] == 'O') { //[3,0]
                            break;
                        } else if (copyMap[i][k] == 'S') {
                            return false;
                        }
                    }
                    // c +1인 방향으로
                    for (int k = j + 1; k < N; k++) { // [3,1] k = 2,3,4
                        if (copyMap[i][k] == 'O') { // [3,2] [3,3] [3,4]
                            break;
                        } else if (copyMap[i][k] == 'S') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
