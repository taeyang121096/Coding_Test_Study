package BaekJun;

import java.io.*;

public class B11403_findRoute {
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());  // 3
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]); // 0 1 0
            }
        }


    }
}
//for (int i = 0; i < N; i++) {
//        for (int j = 0; j < N; j++) {
//        System.out.print(map[i][j] + " ");
//        }
//        System.out.println();
//        }